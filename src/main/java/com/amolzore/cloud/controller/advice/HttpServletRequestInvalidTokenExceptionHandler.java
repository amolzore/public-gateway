package com.amolzore.cloud.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HttpServletRequestInvalidTokenExceptionHandler {
    @ExceptionHandler(HttpServletRequestInvalidTokenException.class)
    @ResponseBody
    public Map<String, Object> handler() {
        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("status", "error");
        m1.put("message", "Sorry, your provided token information expired or not exists.");
        return m1;
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseBody
    public Map<String, Object> handler1() {
        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("status", "error");
        m1.put("message", "Sorry, your provided token is not valid.");
        return m1;
    }
}
