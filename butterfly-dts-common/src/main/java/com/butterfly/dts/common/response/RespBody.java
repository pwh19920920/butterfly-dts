package com.butterfly.dts.common.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;

/**
 * @className: RespBody
 * @description: RespBody
 * @author: pwh
 * @date: 2022/5/10
 **/
@Getter
@Setter
@Data
@SuperBuilder(toBuilder = true)
public class RespBody<T> {

    public enum Status {

        /**
         * 业务处理成功
         */
        SUCCESS(200),

        /**
         * 页面重定向
         */
        REDIRECT(302),

        /**
         * 错误请求
         */
        BAD_REQUEST(400),


        /**
         * 请进行登陆
         */
        UNAUTHORIZED(401),

        /**
         * 权限代码
         */
        FORBIDDEN(403),

        /**
         * 页面不存在
         */
        NOT_FOUND(404),

        /**
         * 无法满足条件的，认定为攻击
         */
        NOT_ACCEPTABLE(406),

        /**
         * 请求超时
         */
        REQUEST_TIMEOUT(408),

        /**
         * 业务访问失败
         */
        ERROR(500),

        /**
         * 网关超时
         */
        GATEWAY_TIMEOUT(504);

        private int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return String.valueOf(getCode());
        }

        public static Status getInstance(int code) {
            return Arrays.asList(Status.values()).parallelStream().filter(currentStatus -> currentStatus.code == code).findFirst().orElse(null);
        }
    }

    /**
     * 响应码
     */
    @Builder.Default
    private Status status = Status.SUCCESS;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 时间戳
     */
    private final Long timestamp = System.currentTimeMillis();

    public RespBody() {

    }

    public RespBody(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * 成功标记
     * @return
     */
    public boolean isSuccess() {
        return this.status != Status.SUCCESS;
    }

    public int getStatus() {
        return status.getCode();
    }

    @JsonIgnore
    @JSONField(serialize = false)
    public Status getStatusEnum() {
        return status;
    }
}
