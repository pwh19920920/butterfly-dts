package com.butterfly.dts.common.exceptions;


import com.butterfly.dts.common.response.RespBody;

/**
 * 业务异常
 *
 * @author Peter
 */
public class ServiceException extends BaseException {

    private static final RespBody.Status status = RespBody.Status.BAD_REQUEST;

    public ServiceException(String message) {
        super(message);
    }

    @Override
    public RespBody.Status getStatus() {
        return status;
    }
}
