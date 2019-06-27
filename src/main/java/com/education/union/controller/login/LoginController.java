package com.education.union.controller.login;

import com.alibaba.fastjson.JSONObject;
import com.education.union.service.LoginService;
import com.education.union.util.CommonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 18:50
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "mobile,password");
        return loginService.authLogin(requestJson);
    }

    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }
}
