package com.education.union;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

    @Test
    public void testGoodsCount() {
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("gradeId", 1);
        jsonObject.put("subjectId", 1);
        System.out.println("个数：" + goodsDao.countMainList(jsonObject));
    }
}
