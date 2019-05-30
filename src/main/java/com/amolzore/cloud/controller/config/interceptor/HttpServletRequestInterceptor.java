package com.amolzore.cloud.controller.config.interceptor;

import com.amolzore.cloud.client.IdentityProviderClient;
import com.amolzore.cloud.controller.advice.HttpServletRequestInvalidTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.amolzore.cloud.controller.ApiPath.IDENTITY_PROVIDER_SERVICE;

@Slf4j
public class HttpServletRequestInterceptor extends HandlerInterceptorAdapter {
    public static final String HEADER_STRING = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final IdentityProviderClient identityProviderClient = new IdentityProviderClient();
        if (!((request.getRequestURI()).contains(IDENTITY_PROVIDER_SERVICE))) {
            request.getHeader(HEADER_STRING);
            if (request.getHeader(HEADER_STRING) == null || !(identityProviderClient.validateToken(request.getHeader(HEADER_STRING)))) {
                throw new HttpServletRequestInvalidTokenException();
            }
        }
        return super.preHandle(request, response, handler);
    }
}