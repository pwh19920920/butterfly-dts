package com.butterfly.dts.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @className: TemplateProperties
 * @description: 相关配置
 * @author: pwh
 * @date: 2022/4/28
 **/
@Getter
@Setter
@ConfigurationProperties("dts.template")
public class TemplateProperties {

    /**
     * 远程地址
     */
    private String remoteUrl = "http://localhost:8080";

    /**
     * 超时时间
     */
    private int timeout = 10;

    /**
     * 业务线
     */
    private String businessLineCode = "default";

    /**
     * 模板地址
     * @return
     */
    public String getRemoteTemplateUrl() {
        return String.format("%s/api/templates/%s", remoteUrl, businessLineCode);
    }

    /**
     * 脚本地址
     * @return
     */
    public String getRemoteScriptUrl() {
        return String.format("%s/api/templates/%s", remoteUrl, businessLineCode);
    }
}
