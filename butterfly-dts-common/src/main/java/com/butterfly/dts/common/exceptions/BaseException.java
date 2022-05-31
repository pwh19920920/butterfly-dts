package com.butterfly.dts.common.exceptions;


import com.butterfly.dts.common.response.RespBody;


/**
 * 基本的异常处理
 *
 * @author Peter
 */
public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    /**
     * 获取回执
     *
     * @return
     */
    public RespBody getExceptionResult() {
        return RespBody.builder().status(getStatus()).message(getMessage()).build();
    }

    /**
     * 获取真正的状态
     *
     * @return
     */
    public abstract RespBody.Status getStatus();

    /**
     * 获取回执
     *
     * @return
     */
    public static BaseException getInstance(RespBody<?> receipt) {
        return new BaseException(receipt.getMessage()) {
            @Override
            public RespBody.Status getStatus() {
                return receipt.getStatusEnum();
            }
        };
    }

    /**
     * 获取回执
     *
     * @return
     */
    public static BaseException getInstance(RespBody.Status status, String message) {
        return getInstance(RespBody.builder().status(status).message(message).build());
    }
}
