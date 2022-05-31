package com.butterfly.dts.admin.config;

import com.butterfly.dts.admin.common.logger.ExceptionLoggerMessage;
import com.butterfly.dts.common.exceptions.BaseException;
import com.butterfly.dts.common.response.RespBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 默认的异常处理中心
 *
 * @author: 彭伟煌(pengweihuang@xmutca.com)
 * @create: 2017-02-13 09:53
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class DefaultExceptionHandler {

    /**
     * 文件上传不符合要求
     *
     * @param ex
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MultipartException.class})
    public RespBody<?> handleMultipartException(MultipartException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "文件不符合要求").info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "文件不符合要求");
    }

    /**
     * 已存在相同数据
     *
     * @param ex
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {DuplicateKeyException.class})
    public RespBody<?> handleDuplicateKeyException(DuplicateKeyException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "已存在相同数据").info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "已存在相同数据");
    }

    /**
     * 系统异常处理
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public RespBody<?> handleException(Exception ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "系统异常", ex).error(log);
        return new RespBody<>(RespBody.Status.ERROR, "服务器开小差了，稍后再试吧");
    }

    /**
     * 系统业务异常，包含熔断异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    public RespBody<?> handleBaseException(BaseException ex, HttpServletResponse response) {
        RespBody<?> respBody = ex.getExceptionResult();
        response.setStatus(respBody.getStatus());
        ExceptionLoggerMessage.getInstance(ex, "系统业务异常", ex).info(log);
        return respBody;
    }

    /**
     * 访问路径被篡改
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public RespBody<?> handleNumberFormatException(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "访问路径被篡改", ex).info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "您当前访问路径已被篡改,请填写正确路径");
    }

    /**
     * 数据绑定异常
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ServletRequestBindingException.class})
    public RespBody<?> handleServletRequestBindingException(ServletRequestBindingException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "请求参数不正确", ex).info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "请求参数不正确");
    }

    /**
     * 数据绑定异常
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MissingServletRequestPartException.class})
    public RespBody<?> handleMissingServletRequestPartException(MissingServletRequestPartException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "请求参数不正确", ex).info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "请求参数不正确");
    }

    /**
     * 请求的方法不存在
     *
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RespBody<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "请求有误", ex).info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "请求有误");
    }

    /**
     * 不支持的媒体类型
     *
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public RespBody<?> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "请求有误", ex).info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "请求有误");
    }

    /**
     * 错误的数字格式
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public RespBody<?> handleNumberFormatException(NumberFormatException ex) {
        ExceptionLoggerMessage.getInstance(ex, "请求有误", ex).info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "请求有误");
    }

    /**
     * 请求数据体为空
     *
     * @param ex
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public RespBody<?> handleAccessDeniedException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        ExceptionLoggerMessage.getInstance(ex, "数据体不能为空", ex).info(log);
        return new RespBody<>(RespBody.Status.BAD_REQUEST, "数据体不能为空");
    }

    /**
     * 校验异常
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BindException.class)
    public RespBody<?> handleBindException(BindException ex) {
        ExceptionLoggerMessage.getInstance(ex, "校验异常", ex).info(log);
        return handleBaseBindAndMethodArgumentNotValidMessage(ex.getAllErrors());
    }

    /**
     * 校验异常
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespBody<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ExceptionLoggerMessage.getInstance(ex, "校验异常", ex).info(log);
        return handleBaseBindAndMethodArgumentNotValidMessage(ex.getBindingResult().getAllErrors());
    }

    /**
     * 同意处理校验数据
     *
     * @param allErrors
     * @return
     */
    protected RespBody<?> handleBaseBindAndMethodArgumentNotValidMessage(List<ObjectError> allErrors) {
        StringBuilder buffer = new StringBuilder();
        for (ObjectError error : allErrors) {
            buffer.append(error.getDefaultMessage()).append(";");
        }

        return new RespBody<>(RespBody.Status.BAD_REQUEST, buffer.toString());
    }
}
