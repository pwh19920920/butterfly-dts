package com.butterfly.dts.admin.common.logger;/**
 * @author: weihuang.peng
 * @version Revision: 0.0.1
 * @Date: 2017/10/25
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version Revision: 0.0.1
 * @author: weihuang.peng
 * @Date: 2017/10/25
 */
@Slf4j
public class AspectLoggerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestLoggerMessage.getInstance().info(log);
        return true;
    }
}
