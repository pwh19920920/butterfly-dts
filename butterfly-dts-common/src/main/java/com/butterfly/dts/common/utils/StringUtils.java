package com.butterfly.dts.common.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;

/**
 * @className: StringUtils
 * @description: StringUtils
 * @author: pwh
 * @date: 2022/5/5
 **/
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 字段串连接
     *
     * @param args
     * @return
     */
    public String concat(String... args) {
        return CollectionUtil.join(Lists.newArrayList(args), "");
    }

    /**
     * 去掉特殊字符、表情符号、空格、"\"符号
     *
     * @param str
     * @return
     */
    public static String filterSpecialChar(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        char a = (char) 0xC2;
        char b = (char) 0xA0;
        str = StringUtils.replaceChars(str, a, (char) 32);
        str = StringUtils.replaceChars(str, b, (char) 32);
        str = str.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff\\u0000|]", "");
        return deleteWhitespace(str);
    }

    /**
     * 替换特殊字符
     *
     * @param str
     * @return
     */
    public static String replaceSpecialChar(String str) {
        str = filterSpecialChar(str);
        String regEx = "[ _`~!@#$%^&*()+=|{}'.:;',\\[\\].·<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t|\b|\0|\\\\|";
        return replacePattern(str, regEx, StringUtils.EMPTY);
    }
}
