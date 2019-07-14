package com.education.union.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.StatusDao;
import com.education.union.service.StatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 19:22
 * Email: fanyafeng@live.cn
 */
@Service
public class StatusServiceImpl implements StatusService {

    @Resource
    private StatusDao statusDao;

    /**
     * 根据id获取状态名称
     *
     * @return
     */
    @Override
    public JSONObject getStatusName(JSONObject jsonObject) {
        return statusDao.getStatusById(jsonObject);
    }

    /**
     * 获取名称列表
     *
     * @return
     */
    @Override
    public List<JSONObject> getStatusNameList() {
        return statusDao.getStatusList();
    }


}
