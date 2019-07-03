package com.education.union.controller.good;

import com.alibaba.fastjson.JSONObject;
import com.education.union.service.GoodsService;
import com.education.union.util.CommonUtil;
import com.education.union.util.constants.ErrorEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-28 22:08
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @PostMapping("/getMajorList")
    public JSONObject getMajorList(@RequestBody JSONObject jsonObject) {
        CommonUtil.hasAllRequired(jsonObject, "pageNum,gradeId");
        return null;
    }

    @PostMapping("/getMainList")
    public JSONObject getListByGradeAndSubject(@RequestBody JSONObject jsonObject) {
        CommonUtil.hasAllRequired(jsonObject, "pageNum");
        int gradeId = jsonObject.getIntValue("gradeId");
        int subjectId = jsonObject.getIntValue("subjectId");
        if (gradeId == 0 && subjectId == 0) {
            return CommonUtil.errorJson(ErrorEnum.E_90003);
        } else {
           return goodsService.getMainList(jsonObject);
        }
    }

    @PostMapping("/fuzzySearch")
    public JSONObject fuzzySearch(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson, "pageNum,name");
        return goodsService.fuzzySearch(requestJson);
    }

}
