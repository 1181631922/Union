package com.education.union.interceptor;

import com.education.union.model.User;
import com.education.union.util.constants.Constants;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * 使用{@link RequestMappingHandlerAdapter}对应的用户身份参数解析器
 * 
 * @author mrrao
 * @date 2014年11月20日, 下午4:42:26
 */
public class IdentityParamResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.getParameterType().equals(User.class)) {
            return true;
        }
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		if (parameter.getParameterType().equals(User.class)) {
			return webRequest.getAttribute(Constants.REQUEST_SUPPLIER, RequestAttributes.SCOPE_REQUEST);
		}
		return null;
	}

}
