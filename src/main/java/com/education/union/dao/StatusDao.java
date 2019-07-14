package com.education.union.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 19:29
 * Email: fanyafeng@live.cn
 */
public interface StatusDao {

    /**
     * 根据id获取状态名称
     * @param jsonObject
     * @return
     */
    JSONObject getStatusById(JSONObject jsonObject);

    /**
     * 获取所有状态列表
     * @return
     */
    List<JSONObject> getStatusList();
}
