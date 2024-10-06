package com.haibu.jarbag.rest.handler;

import io.undertow.server.HttpServerExchange;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletResponseWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class ExchangeAccessor {

    //Very hacky, will break if you enable security debug
    @SneakyThrows
    public HttpServerExchange getExchange(HttpServletResponse response) {
        ServletResponse servletResponse = ((ServletResponseWrapper) response).getResponse();

        Field requestField = servletResponse
                .getClass()
                .getDeclaredField("request");

        requestField.setAccessible(true);

        ServletRequest servletRequest = ((ServletRequestWrapper) requestField
                .get(servletResponse))
                .getRequest();

        Method getRequestMethod = servletRequest
                .getClass()
                .getMethod("getExchange");

        return (HttpServerExchange) getRequestMethod
                .invoke(servletRequest);
    }
}
