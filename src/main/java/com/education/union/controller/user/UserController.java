package com.education.union.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.education.union.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-17 17:59
 * Email: fanyafeng@live.cn
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/getInfo")
    public JSONObject getInfo() {

        return null;
    }
}
