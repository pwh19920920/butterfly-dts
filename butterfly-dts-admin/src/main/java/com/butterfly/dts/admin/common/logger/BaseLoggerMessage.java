package com.butterfly.dts.admin.common.logger;/**
 * @author: weihuang.peng
 * @version Revision: 0.0.1
 * @Date: 2017/10/24
 */

import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;


/**
 *
 * @author: weihuang.peng
 * @version Revision: 0.0.1
 * @Date: 2017/10/24
 */
public abstract class BaseLoggerMessage {

    public enum LoggerType {
        // 主动日志
        TYPE_MESSAGE,

        // 切面日志
        TYPE_ASPECT,

        // 切面日志
        TYPE_REQUEST,

        // 错误日志
        TYPE_EXCEPTION,

        // 业务日志
        TYPE_SERVICE,
    }

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private LoggerType type;

    @Setter(AccessLevel.PROTECTED)
    private Object[] args;

    public void info(Logger logger) {
        logger.info(toString(), args);
    }

    public void debug(Logger logger) {
        logger.debug(toString(), args);
    }

    public void warn(Logger logger) {
        logger.warn(toString(), args);
    }

    public void error(Logger logger) {
        logger.error(toString(), args);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}