package com.education.union;

import com.alibaba.fastjson.JSONObject;
import com.education.union.service.SupplierOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-28 22:32
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierOrderTests {

    @Resource
    public SupplierOrderService supplierOrderService;

    @Test
    public void addSupplierOrder(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("goodsId",1);
        jsonObject.put("userId",2);
        jsonObject.put("supplierId",2);
        supplierOrderService.addSupplierOrder(jsonObject);
    }

}
