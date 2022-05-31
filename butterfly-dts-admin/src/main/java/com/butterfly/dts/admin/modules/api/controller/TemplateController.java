package com.butterfly.dts.admin.modules.api.controller;

import com.alibaba.fastjson.JSON;
import com.butterfly.dts.admin.common.response.PagingRespBody;
import com.butterfly.dts.admin.modules.api.service.TemplateService;
import com.butterfly.dts.common.model.Template;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/{businessLineCode}")
    public PagingRespBody<List<Template>> templates(@PathVariable String businessLineCode) {
        List<Template> templates = templateService.queryTemplateForBusinessLineCode(businessLineCode);
        return PagingRespBody.<List<Template>>builder().data(templates).build();
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(PagingRespBody.<List<Template>>builder().build()));
    }
}
