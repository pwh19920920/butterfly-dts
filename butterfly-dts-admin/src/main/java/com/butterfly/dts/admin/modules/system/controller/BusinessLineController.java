package com.butterfly.dts.admin.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.butterfly.dts.admin.common.response.PagingRespBody;
import com.butterfly.dts.admin.common.vo.PagingVO;
import com.butterfly.dts.admin.modules.system.model.BusinessLine;
import com.butterfly.dts.admin.modules.system.service.BusinessLineService;
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
public class BusinessLineController {

    @NonNull
    private final BusinessLineService businessLineService;

    @RequestMapping
    public PagingRespBody<List<BusinessLine>> test(@ModelAttribute PagingVO<BusinessLine> page) {
        return PagingRespBody.<BusinessLine>buildByPage(businessLineService.page(page));
    }
}
