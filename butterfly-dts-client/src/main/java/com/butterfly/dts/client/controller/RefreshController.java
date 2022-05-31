package com.butterfly.dts.client.controller;

import com.butterfly.dts.client.service.RefreshHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @className: RefreshController
 * @description: 刷新配置
 * @author: pwh
 * @date: 2022/4/28
 **/
@Slf4j
@RestController
@RequestMapping("/dts/refresh")
public class RefreshController {

    @Resource
    private RefreshHandler refreshHandler;

    @Resource
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Resource
    private ScriptEngine scriptEngine;

    /**
     * 刷新模板
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    @RequestMapping("/template")
    public boolean refreshTemplate() throws InterruptedException, ExecutionException, TimeoutException {
        try {
            refreshHandler.refreshTemplate(freeMarkerConfigurer);
        } catch (Exception exception) {
            log.error("从映射配置服务获取模板失败", exception);
            throw exception;
        }
        return true;
    }

    /**
     * 刷新脚本
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     * @throws ScriptException
     */
    @RequestMapping("/script")
    public boolean refreshScript() throws InterruptedException, ExecutionException, TimeoutException, ScriptException {
        try {
            refreshHandler.refreshScript(scriptEngine);
        } catch (Exception exception) {
            log.error("从映射配置服务获取脚本失败", exception);
            throw exception;
        }
        return true;
    }

    /**
     * 刷新全部
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     * @throws ScriptException
     */
    @RequestMapping("/all")
    public boolean refreshAll() throws InterruptedException, ExecutionException, TimeoutException, ScriptException {
        refreshScript();
        refreshTemplate();
        return true;
    }
}
