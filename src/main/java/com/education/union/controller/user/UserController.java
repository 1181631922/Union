package com.education.union.controller.user;

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

    @GetMapping("/list")
    public User listUser() {
        User user = new User();
        user.setName("樊亚风");
        user.setNickname("昵称");
        user.setPassword("testpassword");
        user.setMobile("18010479518");
        return user;
    }
}
