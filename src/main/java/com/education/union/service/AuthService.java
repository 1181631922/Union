package com.education.union.service;

import com.education.union.model.User;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 14:23
 * Email: fanyafeng@live.cn
 */
public interface AuthService {
    User authByToken(String token);
}
