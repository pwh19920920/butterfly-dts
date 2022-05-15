package com.butterfly.dts.admin.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.butterfly.dts.admin.modules.system.model.BusinessLine;
import com.butterfly.dts.admin.modules.system.repository.BusinessLineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @className: BusinessLineService
 * @description: TODO BusinessLineService
 * @author: pwh
 * @date: 2022/5/15
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessLineService extends ServiceImpl<BusinessLineRepository, BusinessLine> {

}
