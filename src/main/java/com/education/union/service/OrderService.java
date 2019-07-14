package com.education.union.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 13:06
 * Email: fanyafeng@live.cn
 */
public interface OrderService {
    /**
     * 根据状态获取订单列表
     * @param jsonObject
     * @return
     */
    JSONObject getUserListByStatus(JSONObject jsonObject);


}
