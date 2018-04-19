package com.example.project.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private PathMatcher pathMatcher = new AntPathMatcher();
    private Map<String, String> authEntryPointMap;

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        authEntryPointMap = new HashMap<>();

        //普通用户登陆入口
        authEntryPointMap.put("/user/**", "/user/login");
        //管理员登陆入口
        authEntryPointMap.put("/admin/**", "/admin/login");
    }

    /**
     * 根据请求跳转到指定的登陆页面
     *
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");

        for (Map.Entry<String, String> entyr : authEntryPointMap.entrySet()) {
            if (pathMatcher.match(entyr.getKey(), uri)) {
                return entyr.getValue();
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}