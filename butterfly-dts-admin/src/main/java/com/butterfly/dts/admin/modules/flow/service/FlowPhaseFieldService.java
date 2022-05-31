package com.butterfly.dts.admin.modules.flow.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.butterfly.dts.admin.modules.flow.model.FlowPhaseField;
import com.butterfly.dts.admin.modules.flow.repository.FlowPhaseFieldRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @className: FlowPhaseFieldService
 * @description: FlowPhaseFieldService
 * @author: pwh
 * @date: 2022/5/30
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class FlowPhaseFieldService extends ServiceImpl<FlowPhaseFieldRepository, FlowPhaseField> {
}
