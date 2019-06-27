package com.education.union.interceptor;

import java.lang.annotation.*;

/**
 * 用来标示Controller方法"期待"登录状态
 * 
 * @author mrrao
 * @date 2014年11月20日, 上午11:50:33
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessRequired {

	/**
	 * 是否必须已登录
	 * 
	 * @return
	 */
	public boolean required() default true;

	public String redirectURL() default "";

	public final String REDIRECT_LOGIN = "/account/login";

}
