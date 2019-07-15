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

    /**
     * 向购物车添加商品
     * 暂时默认数量都为1
     *
     * @param jsonObject
     * @param user
     * @return
     */
    @PostMapping("/addGoods")
    public JSONObject addGoods(@RequestBody JSONObject jsonObject, User user) {
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        CommonUtil.hasAllRequired(jsonObject, "goodsId,price");
        return CommonUtil.successJson(shopService.addGoods(jsonObject));
    }

    /**
     * 删除购物车商品
     *
     * @param jsonObject
     * @param user
     * @return
     */
    @PostMapping("/delGoods")
    public JSONObject delGoods(@RequestBody JSONObject jsonObject, User user) {
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        CommonUtil.hasAllRequired(jsonObject, "goodsId");
        shopService.delGoods(jsonObject);
        return CommonUtil.successJson();
    }

    @PostMapping("/shopSubmit")
    public JSONObject shopSubmit(@RequestBody JSONObject jsonObject, User user) {
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        return shopService.shopSubmit(jsonObject);
    }

    /**
     * 直接购买商品生成订单
     *
     * @param jsonObject
     * @param user
     * @return
     */
    @PostMapping("/orderSubmit")
    public JSONObject orderSubmit(@RequestBody JSONObject jsonObject, User user) {
        CommonUtil.hasAllRequired(jsonObject, "userId,supplierId,goodsId,price");
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        return shopService.orderSubmit(jsonObject);
    }

    @PostMapping("/listShop")
    public JSONObject listShop(@RequestBody JSONObject jsonObject, User user) {
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        return CommonUtil.successJson(shopService.listShop(jsonObject));
    }

}
