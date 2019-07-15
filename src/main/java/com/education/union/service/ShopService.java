package com.education.union.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 18:22
 * Email: fanyafeng@live.cn
 */
public interface ShopService {

    /**
     * 添加商品
     * 如果用户有父订单则不生成，如果没有生成父订单，然后再生成子订单挂在父订单上
     */
    JSONObject addGoods(JSONObject jsonObject);

    /**
     * 删除商品
     * 避免物理删除，进行状态改变
     */
    JSONObject delGoods(JSONObject jsonObject);

    /**
     * 提交购物车生成订单
     */
    JSONObject shopSubmit(JSONObject jsonObject);

    /**
     * 直接提交生成订单
     * 商品直接提交生成订单
     * 例如免费公开课
     */
    JSONObject orderSubmit(JSONObject jsonObject);

    /**
     * 查询用户购物车
     */
    JSONObject listShop(JSONObject jsonObject);
}
