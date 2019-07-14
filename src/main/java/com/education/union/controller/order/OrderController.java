package com.education.union.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.education.union.model.User;
import com.education.union.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-07-14 11:23
 * Email: fanyafeng@live.cn
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 获取用户订单列表
     * <p>
     * 1.订单页状态筛选：全部，已支付，待支付，已取消
     * 2.全部课程状态筛选：全部，系列课，公开课，过期课
     * 3.根据时间来判断是否再进行中或者已结束
     *
     *
     * 不传入任何参数默认为全部列表
     * payStatus  10000 已支付   10001 待支付    10002 已取消      10003 已完成
     *
     * status   40000 系列课   40001 公开课   40002 过期课
     *
     * timeStatus   50000 未开始   50001 已开始   50002 已结束
     */
    @PostMapping("/getOrderList")
    public JSONObject getOrderList(JSONObject jsonObject, User user) {
        Integer userId = user.getId();
        jsonObject.put("userId", userId);
        return orderService.getUserListByStatus(jsonObject);
    }
}
