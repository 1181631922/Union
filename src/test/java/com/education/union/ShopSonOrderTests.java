package com.education.union;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.ShopDao;
import com.education.union.dao.ShoppingSonOrderMapper;
import com.education.union.model.ShoppingSonOrder;
import com.education.union.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 18:43
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopSonOrderTests {

    @Resource
    public ShoppingSonOrderMapper shoppingSonOrderMapper;

    @Resource
    public ShopService shopService;

    @Resource
    public ShopDao shopDao;

    @Test
    public void addShopSonOrder() {
        ShoppingSonOrder shoppingSonOrder = new ShoppingSonOrder();
        shoppingSonOrder.setShoppingOrderId(1);
        shoppingSonOrder.setGoodsId(1);
        shoppingSonOrder.setStatus(0);
        shoppingSonOrder.setPrice(799L);
        shoppingSonOrderMapper.insert(shoppingSonOrder);
        System.out.println(shoppingSonOrder.getId());
    }

    @Test
    public void addShopSonOrderService(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId",3);
        jsonObject.put("goodsId",27);
        jsonObject.put("status",0);
        jsonObject.put("price",799L);
        shopService.addGoods(jsonObject);
//        System.out.println(shopDao.countShopOrderById(jsonObject));
//        System.out.println(shopDao.getShopOrder(jsonObject).toString());
    }

    @Test
    public void delShopSonOrder(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("goodsId",10);
        jsonObject.put("userId",5);
        shopService.delGoods(jsonObject);
    }
}
