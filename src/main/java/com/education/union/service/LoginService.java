package com.education.union.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 18:55
 * Email: fanyafeng@live.cn
 */
public interface LoginService {

    /**
     * 登录表单提交
     * @param jsonObject
     * @return
     */
    JSONObject authLogin(JSONObject jsonObject);

    /**
     * 根据手机号和密码获取对应用户
     */
    JSONObject getUser(String mobile,String password);

    /**
     * 退出登录
     * 可以考虑清楚token
     */
    JSONObject logout();
}
