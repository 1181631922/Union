package com.education.union.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Author： fanyafeng
 * Data： 2019-06-28 22:16
 * Email: fanyafeng@live.cn
 */
public interface SupplierOrderService {
    /**
     * 添加用户订单
     * 用户订单添加需要绑定用户id
     * 需要传入商品id
     * 手动生成创建时间和更新时间
     * 生成唯一订单id
     */
    JSONObject addSupplierOrder(JSONObject jsonObject);

}
