package com.education.union.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-02 20:16
 * Email: fanyafeng@live.cn
 */
public interface GoodsDao {

    Integer countMainList(JSONObject jsonObject);

    List<JSONObject> getMainList(JSONObject jsonObject);
}
