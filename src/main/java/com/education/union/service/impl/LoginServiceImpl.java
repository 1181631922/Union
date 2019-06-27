package com.education.union.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.LoginMapper;
import com.education.union.service.LoginService;
import com.education.union.util.CommonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 18:59
 * Email: fanyafeng@live.cn
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;

    /**
     * 登录表单提交
     *
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject authLogin(JSONObject jsonObject) {
        String mobile = jsonObject.getString("mobile");
        String password = jsonObject.getString("password");
        JSONObject data = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(mobile, password);
        try {
            currentUser.login(token);
            data.put("result", "success");
            data.put("token", currentUser.getSession().getId());
            Session session = currentUser.getSession();
            session.setTimeout(25000);
            session.setAttribute("currentUser", mobile);
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            data.put("result", "fail");
        }
        return CommonUtil.successJson(data);
    }

    /**
     * 根据手机号和密码获取对应用户
     *
     * @param mobile
     * @param password
     */
    @Override
    public JSONObject getUser(String mobile, String password) {
        return loginMapper.getUser(mobile, password);
    }

    /**
     * 退出登录
     */
    @Override
    public JSONObject logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
        }
        return CommonUtil.successJson();
    }


}
