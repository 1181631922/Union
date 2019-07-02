package com.education.union.interceptor;

import com.education.union.model.User;
import com.education.union.service.AuthService;
import com.education.union.util.StringTools;
import com.education.union.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 10:26
 * Email: fanyafeng@live.cn
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    public AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        int accessRequired=accessRequired((HandlerMethod) handler);
        if (accessRequired==AUTH_ERROR){
            return false;
        }
        if (accessRequired==AUTH_NOT_REQUIRED){
            return true;
        }

        User user=getUser(request, (HandlerMethod) handler);
        if (user!=null){
            request.setAttribute(Constants.REQUEST_USER,user);
            return true;
        }else {
            if (accessRequired == AUTH_OPTIONAL) { // 同时支持无帐号的接口设置user=null
                request.setAttribute(Constants.REQUEST_USER, null);
                return true;
            } else { // 根据是否redirectURL是跳转登录页或返回wrongpass
                String redirectURL = getRedirectURL((HandlerMethod) handler);
                if (StringTools.isNullOrEmpty(redirectURL)) {
                    response.sendRedirect(redirectURL);
                    return false;
                } else {
                    return false;
                }
            }
        }
    }


    private User getUser(HttpServletRequest request, HandlerMethod method) throws Exception {
        String token = request.getHeader(Constants.CLIENT_HEADER_HTTP_TOKEN);
        if (!StringTools.isNullOrEmpty(token)) {
            return authService.authByToken(token);
        }
        return null;
    }

    private int accessRequired(HandlerMethod handlerMethod){
        Method method = handlerMethod.getMethod();
        boolean hasUserParam = false;
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = parameterTypes.length - 1; i >= 0; i--) {
            if (parameterTypes[i].getName().equals(User.class.getName())) {
                hasUserParam = true;
                break;
            }
        }

        AccessRequired annotation = method.getAnnotation(AccessRequired.class);
        if (!hasUserParam && annotation == null) {
            return AUTH_NOT_REQUIRED;
        } else if (hasUserParam && (annotation == null || annotation.required())) {
            return AUTH_MUST;
        } else if (hasUserParam && (annotation != null && !annotation.required())) {
            return AUTH_OPTIONAL;
        } else {
            return AUTH_ERROR;
        }
    }

    private String getRedirectURL(HandlerMethod handlerMethod) {
        Method method = handlerMethod.getMethod();
        AccessRequired annotation = method.getAnnotation(AccessRequired.class);
        if (annotation != null) {
            return annotation.redirectURL();
        }
        return null;
    }


    private static int AUTH_NOT_REQUIRED = 1;
    private static int AUTH_MUST = 2;
    private static int AUTH_OPTIONAL = 3;
    private static int AUTH_ERROR = 4;
}
