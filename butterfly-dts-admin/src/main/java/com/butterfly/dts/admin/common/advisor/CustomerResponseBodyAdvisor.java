package com.butterfly.dts.admin.common.advisor;

import com.alibaba.fastjson.JSON;
import com.butterfly.dts.admin.common.logger.ResponseLoggerMessage;
import com.butterfly.dts.admin.common.logger.ServiceLoggerMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 打印响应值日志
 *
 * @author pengweihuang
 */
@Slf4j
@RestControllerAdvice
public class CustomerResponseBodyAdvisor implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 响应值转JSON串输出到日志系统
        ResponseLoggerMessage.getInstance("response body", JSON.toJSONString(body)).info(log);
        return body;
    }
}