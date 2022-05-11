package com.butterfly.dts.common.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @className: DateUtils
 * @description: DateUtils
 * @author: pwh
 * @date: 2022/5/5
 **/
public class DateUtils extends DateUtil {

    /**
     * 获取时间戳
     *
     * @param date
     * @return
     */
    public Long getTime(Date date) {
        return date.getTime();
    }
}
