package com.butterfly.dts.admin.common.logger;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author: weihuang.peng
 * @version Revision: 0.0.1
 * @Date: 2017/10/24
 */
@Getter
@SuperBuilder
public class ExceptionLoggerMessage extends BaseLoggerMessage {

    /**
     * 异常类型
     */
    private final String exception;

    /**
     * 异常消息
     */
    private final String message;

    /**
     * 异常堆栈
     */
    private final String stackTrace;

    @Override
    public LoggerType getType() {
        return LoggerType.TYPE_EXCEPTION;
    }

    /**
     * 获取实例
     * @param ex
     * @param format
     * @param args
     * @return
     */
    public static ExceptionLoggerMessage getInstance(Throwable ex, String format, Object... args) {
        if (null == ex) {
            return ExceptionLoggerMessage.builder().message(format).args(args).build();
        }

        return ExceptionLoggerMessage.builder()
                .exception(ex.getClass().getSimpleName())
                .message(format)
                .args(args)
                .stackTrace(printStackTraceToString(ex.getCause()))
                .build();
    }

    /**
     * 获取异常栈
     * @param t
     * @return
     */
    public static String printStackTraceToString(Throwable t) {
        if (null == t) {
            return StringUtils.EMPTY;
        }
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }
}
