package com.education.union.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.GoodsDao;
import com.education.union.service.GoodsService;
import com.education.union.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-02 20:12
 * Email: fanyafeng@live.cn
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    /**
     * 根据年级，科目筛选课程
     * 如果都不传的话返回空
     *
     * @param jsonObject
     */
    @Override
    public JSONObject getMainList(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = goodsDao.countMainList(jsonObject);
        List<JSONObject> list = goodsDao.getMainList(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}
