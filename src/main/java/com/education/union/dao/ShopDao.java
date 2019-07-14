package com.education.union.dao;

import com.alibaba.fastjson.JSONObject;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 18:30
 * Email: fanyafeng@live.cn
 */
public interface ShopDao {
    Integer countShopOrderById(JSONObject jsonObject);

    JSONObject getShopOrder(JSONObject jsonObject);

    Integer delGoods(JSONObject jsonObject);

}
