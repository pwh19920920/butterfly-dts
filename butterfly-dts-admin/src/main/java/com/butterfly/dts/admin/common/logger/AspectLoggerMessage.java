package com.butterfly.dts.admin.common.logger;/**
 * @author: weihuang.peng
 * @version Revision: 0.0.1
 * @Date: 2017/10/25
 */

import lombok.Builder;
import lombok.Getter;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @version Revision: 0.0.1
 * @author: weihuang.peng
 * @Date: 2017/10/25
 */
@Getter
@Builder
public class AspectLoggerMessage extends BaseLoggerMessage {

    private Long duration;

    private Object target;

    private String signature;

    @Override
    public LoggerType getType() {
        return LoggerType.TYPE_ASPECT;
    }

    public static AspectLoggerMessage getInstance(ProceedingJoinPoint pjp, long beginTimestamp, long endTimestamp) {
        return AspectLoggerMessage
                .builder()
                .target(pjp.getTarget().getClass().getName())
                .signature(pjp.getSignature().getName())
                .duration((endTimestamp - beginTimestamp) / 1000000)
                .build();
    }
}
