package com.butterfly.dts.common.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: RespBody
 * @description: RespBody
 * @author: pwh
 * @date: 2022/5/10
 **/
@Getter
@Setter
@Data
@Builder
public class RespBody<T> {

    /**
     * 响应码
     */
    private int status = 200;

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
}
