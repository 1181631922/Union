package com.education.union.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.*;
import com.education.union.model.ShoppingOrder;
import com.education.union.model.ShoppingSonOrder;
import com.education.union.model.SupplierOrder;
import com.education.union.model.SupplierSonOrder;
import com.education.union.service.ShopService;
import com.education.union.util.CommonUtil;
import com.education.union.util.SnowflakeUtil;
import com.education.union.util.constants.ErrorEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 18:23
 * Email: fanyafeng@live.cn
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;

    @Resource
    private OrderDao orderDao;

    @Resource
    private ShoppingSonOrderMapper shoppingSonOrderMapper;

    @Resource
    private ShoppingOrderMapper shoppingOrderMapper;

    @Resource
    private SupplierOrderMapper supplierOrderMapper;

    @Resource
    private SupplierSonOrderMapper supplierSonOrderMapper;

    /**
     * 添加商品
     * 如果用户有父订单则不生成，如果没有生成父订单，然后再生成子订单挂在父订单上
     */
    @Override
    public JSONObject addGoods(JSONObject jsonObject) {
        Integer userId = jsonObject.getIntValue("userId");

        ShoppingSonOrder shoppingSonOrder = new ShoppingSonOrder();
        shoppingSonOrder.setGoodsId(jsonObject.getIntValue("goodsId"));
        shoppingSonOrder.setStatus(jsonObject.getIntValue("status"));
        shoppingSonOrder.setPrice(jsonObject.getLongValue("price"));

        Integer shopOrderSize = shopDao.countShopOrderById(jsonObject);

        ShoppingOrder shoppingOrder = new ShoppingOrder();
        Integer shopOrderId;
        if (shopOrderSize < 1) {
            //先创建父订单，后创建子订单
            shoppingOrder.setCreateTime(new Date());
            shoppingOrder.setStatus(10001);
            shoppingOrder.setTotalPrice(0L);
            shoppingOrder.setUserId(userId);
            shoppingOrder.setTotalPrice(0L);
            shoppingOrderMapper.insertSelective(shoppingOrder);
            shopOrderId = shoppingOrder.getId();

        } else {
            //直接挂在父订单下
            JSONObject shopOrderObject = shopDao.getShopOrder(jsonObject);
            shoppingOrder.setTotalPrice(shopOrderObject.getLongValue("totalPrice"));
            shopOrderId = shopOrderObject.getIntValue("shopOrderId");

        }
        shoppingSonOrder.setShoppingOrderId(shopOrderId);
        shoppingSonOrderMapper.insertSelective(shoppingSonOrder);

        shoppingOrder.setId(shopOrderId);
        shoppingOrder.setUserId(userId);
        shoppingOrder.setUpdateTime(new Date());
        Long totalPrice = shoppingOrder.getTotalPrice() + shoppingSonOrder.getPrice();
        shoppingOrder.setTotalPrice(totalPrice);

        shoppingOrderMapper.updateByPrimaryKeySelective(shoppingOrder);

        JSONObject data = new JSONObject();
        data.put("shopSonOrderId", shoppingSonOrder.getId());

        return data;
    }

    /**
     * 删除商品
     * 避免物理删除，进行状态改变
     */
    @Override
    public JSONObject delGoods(JSONObject jsonObject) {
//        Integer userId = jsonObject.getIntValue("userId");
        Integer goodsId = jsonObject.getIntValue("goodsId");
        JSONObject shopOrderJson = shopDao.getShopOrder(jsonObject);
//        Integer shopOrderId = shopOrderJson.getIntValue("shopOrderId");
        shopOrderJson.put("goodsId", goodsId);
        shopDao.delGoods(shopOrderJson);
        return CommonUtil.successJson();
    }

    /**
     * 提交购物车生成订单
     *
     * @param jsonObject
     */
    @Override
    public JSONObject shopSubmit(JSONObject jsonObject) {
        try {
            Integer userId = jsonObject.getIntValue("userId");
            jsonObject.put("userId", userId);
            Integer shopSize = shopDao.countShopOrderById(jsonObject);
//            System.out.println("购物车数量：" + shopSize);
            if (shopSize > 0) {
                JSONObject shopOrderJson = shopDao.getShopOrder(jsonObject);
//                System.out.println(shopOrderJson.toString());
                Integer shopOrderId = shopOrderJson.getIntValue("shopOrderId");
//                System.out.println("shopOrderId:" + shopOrderId);
                List<JSONObject> shopSonOrderJson = shopDao.getShopSonOrder(shopOrderJson);
//                System.out.println(shopSonOrderJson.toString());
                Integer shopSonOrderSize = shopSonOrderJson.size();

                Long supplierOrderId = SnowflakeUtil.getInstanceSnowflake().nextId();

                Long totalPrice = 0L;

                for (int i = 0; i < shopSonOrderSize; i++) {
                    JSONObject item = shopSonOrderJson.get(i);
//                    System.out.println(item.toString());
                    Integer goodsId = item.getIntValue("goodsId");
                    Long price = item.getLongValue("price");
                    Integer count = item.getIntValue("count");
                    item.put("shopOrderId",shopOrderId);

                    SupplierSonOrder supplierSonOrder = new SupplierSonOrder();
                    supplierSonOrder.setGoodsId(goodsId);
                    supplierSonOrder.setPrice(price);
                    supplierSonOrder.setCount(count);
                    supplierSonOrder.setSupplierOrderId(supplierOrderId);
                    supplierSonOrderMapper.insertSelective(supplierSonOrder);
                    totalPrice += (price * count);

                    shopDao.delGoods(item);
                }

                SupplierOrder supplierOrder = new SupplierOrder();
                supplierOrder.setUserId(userId);
                supplierOrder.setStatus(40000);
                supplierOrder.setCreateTime(new Date());
                supplierOrder.setUpdateTime(new Date());
                supplierOrder.setSupplierOrderId(supplierOrderId);
                supplierOrder.setTimeStatus(50000);
                supplierOrder.setTotalPrice(totalPrice);
                supplierOrder.setPayStatus(10001);
                supplierOrder.setEndTime(new Date());

                supplierOrderMapper.insertSelective(supplierOrder);

                shopDao.delShop(jsonObject);
            }
            return CommonUtil.successJson();
        } catch (Exception e) {
//            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }

    }

    /**
     * 直接提交生成订单
     * 商品直接提交生成订单
     * 例如免费公开课
     *
     * @param jsonObject
     */
    @Override
    public JSONObject orderSubmit(JSONObject jsonObject) {
        try {
            Integer userId = jsonObject.getIntValue("userId");
            Integer supplierId = jsonObject.getIntValue("supplierId");
            Integer goodsId = jsonObject.getIntValue("goodsId");
            Long price = jsonObject.getLongValue("price");

            Long supplierOrderId = SnowflakeUtil.getInstanceSnowflake().nextId();

            SupplierOrder supplierOrder = new SupplierOrder();
            supplierOrder.setUserId(userId);
            supplierOrder.setSupplierId(supplierId);
            supplierOrder.setStatus(40000);
            supplierOrder.setCreateTime(new Date());
            supplierOrder.setUpdateTime(new Date());
            supplierOrder.setTotalPrice(price);
            supplierOrder.setSupplierOrderId(supplierOrderId);
            supplierOrder.setTimeStatus(50000);
            supplierOrder.setPayStatus(10001);
            supplierOrder.setEndTime(new Date());

            supplierOrderMapper.insertSelective(supplierOrder);

            SupplierSonOrder supplierSonOrder = new SupplierSonOrder();
            supplierSonOrder.setSupplierOrderId(supplierOrderId);
            supplierSonOrder.setGoodsId(goodsId);
            supplierSonOrder.setPrice(price);
            supplierSonOrder.setCount(1);

            supplierSonOrderMapper.insertSelective(supplierSonOrder);

            return CommonUtil.successJson();
        } catch (Exception e) {
//            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }
    }


    /**
     * 查询用户购物车列表
     */
    @Override
    public JSONObject listShop(JSONObject jsonObject) {
        Integer shopSize = shopDao.countShopOrderById(jsonObject);
        JSONObject data = new JSONObject();
        if (shopSize > 0) {
            JSONObject shopOrderJson = shopDao.getShopOrder(jsonObject);
            List<JSONObject> shopOrderListJson = shopDao.getShopSonOrder(shopOrderJson);
            data.put("shopInfo", shopOrderJson);
            data.put("shopList", shopOrderListJson);
        }
        return data;
    }


}
