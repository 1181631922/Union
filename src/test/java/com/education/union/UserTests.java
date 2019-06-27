package com.education.union;

import com.education.union.model.User;
import com.education.union.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 09:58
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Resource
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("樊亚风");
        user.setNickname("昵称");
        user.setPassword("testpassword");
        user.setMobile("18010479518");
        userService.addUser(user);
    }
}
