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

import java.util.Collection;
import java.util.List;

/**
 * @className: BusinessLineController
 * @description: BusinessLineController
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
    public PagingRespBody<Collection<SystemBusinessLine>> test(@ModelAttribute PagingVO<SystemBusinessLine> page) {
        return PagingRespBody.buildByPage(systemBusinessLineService.page(page));
    }
}
