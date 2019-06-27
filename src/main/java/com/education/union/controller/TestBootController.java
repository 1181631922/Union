package com.education.union.controller;

import com.education.union.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author： fanyafeng
 * Data： 2019-06-15 08:43
 * Email: fanyafeng@live.cn
 */
@RestController
@RequestMapping("/testBoot")
public class TestBootController {
    @RequestMapping("getUser")
    public User getUser() {
        User user = new User();
        user.setName("樊亚风");
        return user;
    }
}
