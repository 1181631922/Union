package com.education.union;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.OrderDao;
import com.education.union.service.OrderService;
import com.education.union.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 16:40
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTests {
    @Resource
    public OrderDao orderDao;

    @Resource
    public OrderService orderService;

    @Resource
    public ShopService shopService;

    @Test
    public void getOrderList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", 2);
        System.out.println(orderDao.getUserListByStatus(jsonObject).toString());
    }

    @Test
    public void getOrderListByService() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum", 1);
        jsonObject.put("userId", 2);
        System.out.println(orderService.getUserListByStatus(jsonObject).toString());
    }

//    Integer userId = jsonObject.getIntValue("userId");
//    Integer supplierId = jsonObject.getIntValue("supplierId");
//    Integer goodsId = jsonObject.getIntValue("goodsId");
//    Long price = jsonObject.getLongValue("price");

    @Test
    public void orderSubmit() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", 2);
        jsonObject.put("supplierId", 2);
        jsonObject.put("goodsId", 5);
        jsonObject.put("price", 799L);
        shopService.orderSubmit(jsonObject);
    }

    @Test
    public void shopSubmit(){

    }
}
