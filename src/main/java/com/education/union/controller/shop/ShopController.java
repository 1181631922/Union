package com.education.union.controller.shop;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.ShoppingSonOrderMapper;
import com.education.union.model.ShoppingSonOrder;
import com.education.union.model.User;
import com.education.union.service.ShopService;
import com.education.union.util.CommonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 13:00
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopService shopService;

    @PostMapping("/addGoods")
    public JSONObject addGoods(@RequestBody JSONObject jsonObject, User user) {
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        CommonUtil.hasAllRequired(jsonObject, "goodsId,price");
        return CommonUtil.successJson(shopService.addGoods(jsonObject));
    }

    @PostMapping("/delGoods")
    public JSONObject delGoods(@RequestBody JSONObject jsonObject, User user) {
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        CommonUtil.hasAllRequired(jsonObject, "goodsId");
        shopService.delGoods(jsonObject);
        return CommonUtil.successJson();
    }
}
