package com.education.union.util.constants;

/**
 * Author： fanyafeng
 * Data： 2019-06-17 18:16
 * Email: fanyafeng@live.cn
 * <p>
 * 通用常量类，单个业务的常量请单开一个类，方便常量的分类管理
 */
public class Constants {
    final public static String PREFIX = "education64union";

    public static final String SUCCESS_CODE = "100";
    public static final String SUCCESS_MSG = "请求成功";

    /**
     * session中存放用户信息的key值
     */
    public static final String SESSION_USER_INFO = "userInfo";
    public static final String SESSION_USER_PERMISSION = "userPermission";

    /**
     * 请求加密http token 的header
     */
    final public static String CLIENT_HEADER_HTTP_TOKEN = "x-union-http-key";

    /**
     * 用户存储
     */
    final public static String REQUEST_USER = "user";
}
