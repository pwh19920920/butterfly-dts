package com.butterfly.dts.client;

import com.butterfly.dts.client.config.TemplateConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @className: AutoConfiguration
 * @description: AutoConfiguration
 * @author: pwh
 * @date: 2022/5/5
 **/
@Configuration
@ComponentScan({"com.butterfly.dts.client.controller", "com.butterfly.dts.client.service"})
@Import(TemplateConfiguration.class)
public class AutoConfiguration {
}