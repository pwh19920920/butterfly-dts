package com.butterfly.dts.admin.common.logger;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * request请求日志
 *
 * @author weihuang
 */
@Getter
@SuperBuilder
public class RequestLoggerMessage extends BaseLoggerMessage {

    public static final String UNKNOWN = "unknown";

    private final String method;

    private final String ip;

    private final String uri;

    private final String queryString;

    private final Object params;

    @Override
    public LoggerType getType() {
        return LoggerType.TYPE_REQUEST;
    }

    /**
     * 获取实例
     * @return
     */
    public static RequestLoggerMessage getInstance(String queryString, Object params) throws IOException {
        if (null != RequestContextHolder.getRequestAttributes()) {
            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            return RequestLoggerMessage
                    .builder()
                    .ip(getIpAddress(req))
                    .method(req.getMethod())
                    .uri(req.getRequestURI())
                    .queryString(queryString)
                    .params(params)
                    .build();
        }
        return RequestLoggerMessage.builder().build();
    }

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     */
    private static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }

            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }

            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }

            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }

            if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = ips[index];
                if (!(UNKNOWN.equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}