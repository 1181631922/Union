package com.education.union.util;

/**
 * Author： fanyafeng
 * Data： 2019-06-17 18:10
 * Email: fanyafeng@live.cn
 */
public class StringTools {

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}
