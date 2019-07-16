package com.education.union;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.*;
import com.education.union.model.SupplierOrder;
import com.education.union.model.SupplierSonOrder;
import com.education.union.service.ShopService;
import com.education.union.util.SnowflakeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-02 20:36
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTests {
    @Resource
    private GoodsDao goodsDao;

    @Resource
    private ShopDao shopDao;

    @Resource
    private ShopService shopService;

    @Resource
    private SupplierSonOrderMapper supplierSonOrderMapper;

    @Resource
    private SupplierOrderMapper supplierOrderMapper;

    @Resource
    private ShoppingOrderMapper shoppingOrderMapper;

    @Resource
    private ShoppingSonOrderMapper shoppingSonOrderMapper;

    @Test
    public void testGoodsCount() {
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("gradeId", 1);
        jsonObject.put("subjectId", 1);
        System.out.println("个数：" + goodsDao.countMainList(jsonObject));
    }

    @Test
    public void testShop() {
        try {
            JSONObject jsonObject = new JSONObject();
            Integer userId = 3;
            jsonObject.put("userId", userId);
            Integer shopSize = shopDao.countShopOrderById(jsonObject);
            System.out.println("购物车数量：" + shopSize);
            if (shopSize > 0) {
                JSONObject shopOrderJson = shopDao.getShopOrder(jsonObject);
                System.out.println(shopOrderJson.toString());
                Integer shopOrderId = shopOrderJson.getIntValue("shopOrderId");
                System.out.println("shopOrderId:" + shopOrderId);
                List<JSONObject> shopSonOrderJson = shopDao.getShopSonOrder(shopOrderJson);
                System.out.println(shopSonOrderJson.toString());
                Integer shopSonOrderSize = shopSonOrderJson.size();

                Long supplierOrderId = SnowflakeUtil.getInstanceSnowflake().nextId();

                Long totalPrice = 0L;

                for (int i = 0; i < shopSonOrderSize; i++) {
                    JSONObject item = shopSonOrderJson.get(i);
                    System.out.println(item.toString());
                    Integer goodsId = item.getIntValue("goodsId");
                    Long price = item.getLongValue("price");
                    Integer count = item.getIntValue("count");
                    item.put("shopOrderId", shopOrderId);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShopList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", 2);
        System.out.println(shopService.listShop(jsonObject));
    }

    @Test
    public void testAddGoods() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", 6);
        jsonObject.put("goodsId", 8);
        jsonObject.put("goodsCount", 1);
        shopService.addGoods(jsonObject);
    }
}
