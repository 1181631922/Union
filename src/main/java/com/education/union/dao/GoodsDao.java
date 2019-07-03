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

    /**
     * 模糊统计数量
     */
    Integer countFuzzyGoods(JSONObject jsonObject);

    /**
     * 模糊搜索
     */
    List<JSONObject> getFuzzyGoods(JSONObject jsonObject);
}
