package com.education.union.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Author： fanyafeng
 * Data： 2019-07-02 20:11
 * Email: fanyafeng@live.cn
 */
public interface GoodsService {
    /**
     * 根据年级，科目筛选课程
     * 如果都不传的话返回空
     */
    JSONObject getMainList(JSONObject jsonObject);
}
