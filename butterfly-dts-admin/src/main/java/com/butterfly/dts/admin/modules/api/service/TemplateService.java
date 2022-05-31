package com.butterfly.dts.admin.modules.api.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.butterfly.dts.admin.modules.transform.model.TransformMappingResult;
import com.butterfly.dts.admin.modules.transform.service.TransformMappingResultService;
import com.butterfly.dts.common.model.Template;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: TemplateService
 * @description: TemplateService
 * @author: pwh
 * @date: 2022/5/31
 **/
@Service
@RequiredArgsConstructor
public class TemplateService {

    @NonNull
    private final TransformMappingResultService transformMappingResultService;

    /**
     * 通过业务线码查询模板
     *
     * @param businessLineCode
     * @return
     */
    public List<Template> queryTemplateForBusinessLineCode(String businessLineCode) {
        // 查询所有模板
        List<TransformMappingResult> transformMappingResults = transformMappingResultService
                .lambdaQuery()
                .eq(TransformMappingResult::getSystemBusinessLineCode, businessLineCode)
                .eq(TransformMappingResult::getDeleted, Boolean.FALSE).list();

        // 数据转换
        return transformMappingResults
                .stream()
                .map(item -> Template.builder().template(item.getMappingResult()).name(item.getTransformMappingCode()).build())
                .collect(Collectors.toList());
    }
}
