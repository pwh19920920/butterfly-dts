package com.butterfly.dts.admin.modules.system.controller;

import com.butterfly.dts.admin.common.response.PagingRespBody;
import com.butterfly.dts.admin.common.vo.PagingVO;
import com.butterfly.dts.admin.modules.system.model.SystemBusinessLine;
import com.butterfly.dts.admin.modules.system.service.SystemBusinessLineService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: BusinessLineController
 * @description: TODO 类描述
 * @author: pwh
 * @date: 2022/5/15
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/system/businessLine")
public class SystemBusinessLineController {

    @NonNull
    private final SystemBusinessLineService systemBusinessLineService;

    @RequestMapping
    public PagingRespBody<List<SystemBusinessLine>> test(@ModelAttribute PagingVO<SystemBusinessLine> page) {
        return PagingRespBody.<SystemBusinessLine>buildByPage(systemBusinessLineService.page(page));
    }
}