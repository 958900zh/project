package com.example.project.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    private final LoginUrlEntryPoint entryPoint;

    public LoginAuthFailHandler(LoginUrlEntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String target = entryPoint.determineUrlToUseForThisRequest(request, response, exception);

        target += "?" + exception.getMessage();
        super.setDefaultFailureUrl(target);
        super.onAuthenticationFailure(request, response, exception);
    }
}
