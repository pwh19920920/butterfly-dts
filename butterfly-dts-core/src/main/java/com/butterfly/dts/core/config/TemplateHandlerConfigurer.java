package com.butterfly.dts.core.config;

import java.util.Map;

/**
 * 模板处理器配置
 * @author pengweihuang
 */
public interface TemplateHandlerConfigurer {

    /**
     * 注册
     * @param bindData
     */
    void register(Map<String, Object> bindData);
}
