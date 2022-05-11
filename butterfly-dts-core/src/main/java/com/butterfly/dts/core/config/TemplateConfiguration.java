package com.butterfly.dts.core.config;

import com.butterfly.dts.core.service.RefreshHandler;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author pengweihuang
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(TemplateProperties.class)
public class TemplateConfiguration {

    @Resource
    private RefreshHandler refreshHandler;

    /**
     * 模板引擎从远程注入
     * @return
     * @throws IOException
     * @throws TemplateException
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException, TemplateException, InterruptedException, ExecutionException, TimeoutException {
        FreeMarkerConfigurer freeMarkerConfigurer = initFreeMarkerConfigurer();
        try {
            refreshHandler.refreshTemplate(freeMarkerConfigurer);
            return freeMarkerConfigurer;
        } catch (Exception exception) {
            log.error("从映射配置服务获取模板失败", exception);
            throw exception;
        }
    }

    /**
     * 脚本引擎从远程注入
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     * @throws ScriptException
     */
    @Bean
    public ScriptEngine scriptEngine() throws InterruptedException, ExecutionException, TimeoutException, ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        try {
            refreshHandler.refreshScript(scriptEngine);
        } catch (Exception exception) {
            log.error("从映射配置服务获取脚本失败", exception);
            throw exception;
        }
        return scriptEngine;
    }

    /**
     * 默认模板处理器注入一个空实现
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(TemplateHandlerConfigurer.class)
    public TemplateHandlerConfigurer configurer() {
        return bindData -> {};
    }

    private Properties initProp() {
        Properties pro = new Properties();
        pro.setProperty("template_update_delay", "1800");
        pro.setProperty("default_encoding", "UTF-8");
        pro.setProperty("locale", "zh_CN");
        return pro;
    }

    private FreeMarkerConfigurer initFreeMarkerConfigurer() throws IOException, TemplateException {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setFreemarkerSettings(initProp());
        freeMarkerConfigurer.afterPropertiesSet();
        freeMarkerConfigurer.getConfiguration().setNumberFormat("#");
        return freeMarkerConfigurer;
    }
}