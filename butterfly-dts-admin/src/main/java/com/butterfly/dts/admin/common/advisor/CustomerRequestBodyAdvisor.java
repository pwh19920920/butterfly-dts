package com.butterfly.dts.admin.common.advisor;

import com.alibaba.fastjson.JSON;
import com.butterfly.dts.admin.common.logger.RequestLoggerMessage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

/**
* 打印请求参数日志
 * @author pengweihuang
 */
@Slf4j
@RestControllerAdvice
public class CustomerRequestBodyAdvisor extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 只处理@RequestBody注解了的参数
        return true;
    }

    @SneakyThrows
    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 参数对象转JSON字符串
        RequestLoggerMessage.builder().params(JSON.toJSONString(body)).build().info(log);
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}