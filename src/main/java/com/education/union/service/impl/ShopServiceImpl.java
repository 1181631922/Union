package com.education.union.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.ShopDao;
import com.education.union.dao.ShoppingOrderMapper;
import com.education.union.dao.ShoppingSonOrderMapper;
import com.education.union.model.ShoppingOrder;
import com.education.union.model.ShoppingSonOrder;
import com.education.union.service.ShopService;
import com.education.union.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
    private ShoppingSonOrderMapper shoppingSonOrderMapper;

    @Resource
    private ShoppingOrderMapper shoppingOrderMapper;

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
}
