package com.education.union.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 19:20
 * Email: fanyafeng@live.cn
 */
public interface StatusService {

    /**
     * 根据id获取状态名称
     *
     * @return
     */
    JSONObject getStatusName(JSONObject jsonObject);

    /**
     * 获取名称列表
     * @return
     */
    List<JSONObject> getStatusNameList();
}
