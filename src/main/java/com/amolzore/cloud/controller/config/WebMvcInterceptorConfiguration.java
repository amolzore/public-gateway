package com.amolzore.cloud.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.amolzore.cloud.controller.config.interceptor.*;

@Configuration
@EnableWebMvc
public class WebMvcInterceptorConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpServletRequestInterceptor())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}