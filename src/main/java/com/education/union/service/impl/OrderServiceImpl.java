package com.education.union.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.OrderDao;
import com.education.union.model.User;
import com.education.union.service.OrderService;
import com.education.union.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 13:07
 * Email: fanyafeng@live.cn
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * 根据状态获取订单列表
     *
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject getUserListByStatus(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = orderDao.countByStatus(jsonObject);
        List<JSONObject> list = orderDao.getUserListByStatus(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

}
