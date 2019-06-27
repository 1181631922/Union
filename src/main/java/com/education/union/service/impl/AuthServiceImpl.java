package com.education.union.service.impl;

import com.education.union.dao.SupplierMapper;
import com.education.union.dao.UserMapper;
import com.education.union.model.User;
import com.education.union.service.AuthService;
import com.education.union.util.Base64Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 14:27
 * Email: fanyafeng@live.cn
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User authByToken(String token) {
        String[] strings = token.split("%");
        if (strings.length != 2) {
            return null;
        }
        String userId = Base64Util.decode(strings[0]);
        String userToken = Base64Util.decodeToken(strings[1]);
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if (user != null && userToken.equals(user.getUserToken())) {
            return user;
        } else {
            return null;
        }
    }
}
