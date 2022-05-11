package com.butterfly.dts.core.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.butterfly.dts.common.model.Template;
import com.butterfly.dts.common.response.RespBody;
import com.butterfly.dts.core.config.TemplateProperties;
import freemarker.cache.StringTemplateLoader;
import jodd.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.List;
import java.util.concurrent.*;

/**
 * @className: Refresh
 * @description: Refresh
 * @author: pwh
 * @date: 2022/4/28
 **/
@Slf4j
@Component
public class RefreshHandler {

    private static final ExecutorService THREAD_POOL_EXECUTOR = Executors.newFixedThreadPool(2);

    @Resource
    private TemplateProperties templateProperties;

    /**
     * 获取远程模板
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    public void refreshTemplate(FreeMarkerConfigurer freeMarkerConfigurer) throws InterruptedException, ExecutionException, TimeoutException {
        Future<RespBody<List<Template>>> future = THREAD_POOL_EXECUTOR.submit(() -> {
            log.info("从映射配置服务获取模板请求：{}", templateProperties.getRemoteTemplateUrl());
            String respText = HttpRequest.get(templateProperties.getRemoteTemplateUrl()).send().bodyText();
            log.info("从映射配置服务获取模板响应：{}", respText);
            return JSON.parseObject(respText, new TypeReference<RespBody<List<Template>>>(){});
        });
        List<Template> templates = future.get(templateProperties.getTimeout(), TimeUnit.SECONDS).getData();
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        templates.forEach(item -> {
            stringLoader.putTemplate(item.getName(), item.getTemplate());
        });
        freeMarkerConfigurer.getConfiguration().setTemplateLoader(stringLoader);
    }

    /**
     * 获取远程模板
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    public void refreshScript(ScriptEngine scriptEngine) throws InterruptedException, ExecutionException, TimeoutException, ScriptException {
        Future<RespBody<List<String>>> future = THREAD_POOL_EXECUTOR.submit(() -> {
            log.info("从映射配置服务获取脚本请求：{}", templateProperties.getRemoteScriptUrl());
            String respText = HttpRequest.get(templateProperties.getRemoteScriptUrl()).send().bodyText();
            log.info("从映射配置服务获取脚本响应：{}", respText);
            return JSON.parseObject(respText, new TypeReference<RespBody<List<String>>>(){});
        });
        List<String> scripts = future.get(templateProperties.getTimeout(), TimeUnit.SECONDS).getData();
        for (String script : scripts) {
            scriptEngine.eval(script);
        }
    }
}
