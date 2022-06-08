package com.butterfly.dts.admin.common.logger;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @version Revision: 0.0.1
 * @author: weihuang.peng
 * @Date: 2017/10/25
 */
@Getter
@SuperBuilder
public class ResponseLoggerMessage extends BaseLoggerMessage {

    /**
     * 业务标题
     */
    private final String title;

    /**
     * 格式输出
     */
    private final String message;

    @Override
    public LoggerType getType() {
        return LoggerType.TYPE_RESPONSE;
    }

    /**
     * 获取实例
     * @param format
     * @param args
     * @return
     */
    public static ResponseLoggerMessage getInstance(String title, String format, Object... args) {
        return ResponseLoggerMessage.builder()
                .title(title)
                .message(format)
                .args(args)
                .build();
    }
}
