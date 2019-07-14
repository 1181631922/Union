package com.education.union.controller.status;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.StatusDao;
import com.education.union.dao.StatusMapper;
import com.education.union.service.StatusService;
import com.education.union.util.CommonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 19:24
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

    @Resource
    private StatusService statusService;

    @PostMapping("/getStatusById")
    public JSONObject getStatusById(@RequestBody JSONObject jsonObject) {
        CommonUtil.hasAllRequired(jsonObject, "statusId");
        return CommonUtil.successJson(statusService.getStatusName(jsonObject));
    }

    @PostMapping("/getStatusList")
    public JSONObject getStatusList() {
        return CommonUtil.successJson(statusService.getStatusNameList());
    }

}
