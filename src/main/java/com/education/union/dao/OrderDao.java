package com.education.union.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 13:03
 * Email: fanyafeng@live.cn
 */
public interface OrderDao {
    /**
     * 获取用户订单列表
     */
    List<JSONObject> getUserListByStatus(JSONObject jsonObject);

    /**
     * 根据状态获取size
     */
    Integer countByStatus(JSONObject jsonObject);
}
