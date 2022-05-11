package com.butterfly.dts.core.service;

import com.butterfly.dts.common.utils.DateUtils;
import com.butterfly.dts.common.utils.EncryptUtils;
import com.butterfly.dts.common.utils.JsonUtils;
import com.butterfly.dts.common.utils.StringUtils;
import com.butterfly.dts.core.config.TemplateHandlerConfigurer;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @className: FreemarkerHandler
 * @description: 模板处理类
 * @author: pwh
 * @date: 2022/4/28
 **/
@Component
public class FreemarkerHandler {

    public static final DateUtils DATE_HANDLER = new DateUtils();
    public static final StringUtils STRING_HANDLER = new StringUtils();
    public static final EncryptUtils ENCRYPT_HANDLER = new EncryptUtils();
    public static final JsonUtils JSON_HANDLER = new JsonUtils();

    @Resource
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Resource
    private ScriptEngineHandler scriptEngineHandler;

    @Resource
    private TemplateHandlerConfigurer templateHandlerConfigurer;

    /**
     * 渲染
     * @param templateName
     * @param bindData
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public String handler(String templateName, Map<String, Object> bindData) throws IOException, TemplateException {
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
        bindData.put("script", scriptEngineHandler);
        bindData.put("date", DATE_HANDLER);
        bindData.put("string", STRING_HANDLER);
        bindData.put("encrypt", ENCRYPT_HANDLER);
        bindData.put("json", JSON_HANDLER);

        // 注册自定义处理器
        templateHandlerConfigurer.register(bindData);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, bindData);
    }
}