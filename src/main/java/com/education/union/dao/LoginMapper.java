package com.education.union.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

/**
 * Author： fanyafeng
 * Data： 2019-06-18 19:05
 * Email: fanyafeng@live.cn
 */
public interface LoginMapper {
    /**
     * 根据用户手机号和密码查找用户信息
     *
     * @return
     */
    JSONObject getUser(@Param("mobile") String mobile, @Param("password") String password);

    /**
     * 根据永华手机号和密码查找用户id，token
     */
    JSONObject getToken(String mobile,String password);
}
