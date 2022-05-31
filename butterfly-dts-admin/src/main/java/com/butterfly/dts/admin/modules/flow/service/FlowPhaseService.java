package com.butterfly.dts.admin.modules.flow.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.butterfly.dts.admin.modules.flow.model.FlowPhase;
import com.butterfly.dts.admin.modules.flow.repository.FlowPhaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @className: FlowPhaseService
 * @description: FlowPhaseService
 * @author: pwh
 * @date: 2022/5/30
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class FlowPhaseService extends ServiceImpl<FlowPhaseRepository, FlowPhase> {
}
