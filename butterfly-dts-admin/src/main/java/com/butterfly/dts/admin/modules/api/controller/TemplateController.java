package com.butterfly.dts.admin.modules.api.controller;

import com.butterfly.dts.admin.common.response.PagingRespBody;
import com.butterfly.dts.admin.modules.api.service.TemplateService;
import com.butterfly.dts.common.model.Template;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @className: TemplateController
 * @description: TODO 类描述
 * @author: pwh
 * @date: 2022/5/31
 **/
@RestController
@RequestMapping("/api/templates")
@RequiredArgsConstructor
public class TemplateController {

    @NonNull
    private final TemplateService templateService;

    /**
     * 获取全部模板
     * @param businessLineCode
     * @return
     */
    @RequestMapping("/{businessLineCode}")
    public PagingRespBody<Collection<Template>> templates(@PathVariable String businessLineCode) {
        List<Template> templates = templateService.queryTemplateForBusinessLineCode(businessLineCode);
        return PagingRespBody.buildByData(templates);
    }
}
