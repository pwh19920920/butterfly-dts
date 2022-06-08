package com.butterfly.dts.admin.config;

import com.butterfly.dts.admin.common.logger.RequestLoggerMessage;
import com.butterfly.dts.common.response.RespBody;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @className: WebConfiguration
 * @description: TODO 类描述
 * @author: pwh
 * @date: 2022/6/1
 **/
@Configuration
@RestController
public class WebConfiguration implements ErrorPageRegistrar, WebMvcConfigurer {

    /**
     * 拦截器
     * @param registry 注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.aspectLoggerInterceptor());
    }

    /**
     * 切面日志
     *
     * @return 拦截器
     */
    @Bean
    public AspectLoggerInterceptor aspectLoggerInterceptor() {
        return new AspectLoggerInterceptor();
    }

    /**
     * 常见错误页面的数据处理
     * @param registry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
        registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
        registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/error/404")
    public RespBody<?> error404() {
        return new RespBody<>(RespBody.Status.NOT_FOUND, "page not found.");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @RequestMapping(value = "/error/500")
    public RespBody<?> error500() {
        return new RespBody<>(RespBody.Status.ERROR, "服务器开小差了，稍后再试吧");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @RequestMapping(value = "/error/400")
    public RespBody<?> error400() {
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "this request is bad.");
    }

    /**
     * 日志拦截器
     */
    @Slf4j
    public static class AspectLoggerInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            MDC.put("X-B3-TraceId", UUID.randomUUID().toString());
            RequestLoggerMessage.getInstance(request.getQueryString(), request.getParameterMap()).info(log);
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            MDC.clear();
        }
    }
}
