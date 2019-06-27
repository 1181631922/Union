package com.education.union.config.exception;

import com.alibaba.fastjson.JSONObject;
import com.education.union.util.CommonUtil;
import com.education.union.util.constants.ErrorEnum;

/**
 * Author： fanyafeng
 * Data： 2019-06-17 18:46
 * Email: fanyafeng@live.cn
 * <p>
 * 自定义错误工具类
 * 比如在验证参数时，如果不符合要求，可以抛出此错误类
 * 拦截器可以统一拦截此错误，将其中json返回给前端
 */
public class CommonJsonException extends RuntimeException{
    private JSONObject resultJson;

    /**
     * 调用时可以再任何代码处throws这个exception
     * 都会统一被拦截，并封装好json返回给前台
     *
     * @param errorEnum     以错误的errorEnum做参数
     */
    public CommonJsonException(ErrorEnum errorEnum) {
        this.resultJson = CommonUtil.errorJson(errorEnum);
    }

    public CommonJsonException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }

    public JSONObject getResultJson() {
        return resultJson;
    }
}
