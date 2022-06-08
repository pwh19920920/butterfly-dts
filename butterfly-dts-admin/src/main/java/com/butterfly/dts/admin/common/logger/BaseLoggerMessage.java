package com.butterfly.dts.admin.common.logger;/**
 * @author: weihuang.peng
 * @version Revision: 0.0.1
 * @Date: 2017/10/24
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.slf4j.Logger;
import org.slf4j.MDC;


/**
 * @version Revision: 0.0.1
 * @author: weihuang.peng
 * @Date: 2017/10/24
 */
@SuperBuilder
public abstract class BaseLoggerMessage {

    public enum LoggerType {
        // 主动日志
        TYPE_MESSAGE,

        // 切面日志
        TYPE_ASPECT,

        // 切面日志
        TYPE_REQUEST,

        // 切面日志
        TYPE_RESPONSE,

        // 错误日志
        TYPE_EXCEPTION,

        // 业务日志
        TYPE_SERVICE,
    }

    /**
     * 业务类型
     */
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    @JSONField(serialize = false)
    private LoggerType type;

    /**
     * 相关参数
     */
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    @JSONField(serialize = false)
    private Object[] args;

    /**
     * 在打印之前
     */
    public void outBefore() {
        MDC.put("type", this.getType().toString());
    }

    /**
     * info
     *
     * @param logger
     */
    public void info(Logger logger) {
        if (logger.isInfoEnabled()) {
            this.outBefore();
            logger.info(this.toString(), args);
        }
    }

    /**
     * debug
     *
     * @param logger
     */
    public void debug(Logger logger) {
        if (logger.isDebugEnabled()) {
            this.outBefore();
            logger.debug(this.toString(), args);
        }
    }

    /**
     * warn
     *
     * @param logger
     */
    public void warn(Logger logger) {
        if (logger.isWarnEnabled()) {
            this.outBefore();
            logger.warn(this.toString(), args);
        }
    }

    /**
     * error
     *
     * @param logger
     */
    public void error(Logger logger) {
        if (logger.isErrorEnabled()) {
            this.outBefore();
            logger.error(this.toString(), args);
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}