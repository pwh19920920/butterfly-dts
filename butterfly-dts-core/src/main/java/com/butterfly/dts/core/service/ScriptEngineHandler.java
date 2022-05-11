package com.butterfly.dts.core.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * @className: ScriptHandler
 * @description: 脚本执行
 * @author: pwh
 * @date: 2022/4/28
 **/
@Component
public class ScriptEngineHandler {

    @Resource
    private ScriptEngine scriptEngine;

    /**
     * 执行script
     *
     * @param method
     * @param args
     * @return
     * @throws ScriptException
     * @throws NoSuchMethodException
     */
    public String exec(String method, Object... args) throws ScriptException, NoSuchMethodException {
        if (StringUtils.isBlank(method)) {
            return null;
        }

        Invocable invocable = (Invocable) scriptEngine;
        Object result = invocable.invokeFunction(method, args);
        return result.toString();
    }
}