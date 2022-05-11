package com.butterfly.dts.core;

import com.butterfly.dts.core.config.TemplateConfiguration;
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
@ComponentScan({"com.butterfly.dts.core.controller", "com.butterfly.dts.core.service"})
@Import(TemplateConfiguration.class)
public class AutoConfiguration {
}