package com.butterfly.dts.admin.modules.flow.repository;

import com.butterfly.dts.admin.common.repository.BaseRepository;
import com.butterfly.dts.admin.modules.flow.model.FlowPhase;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: FlowPhaseRepository
 * @description: FlowPhaseRepository
 * @author: pwh
 * @date: 2022/5/11
 **/
@Mapper
public interface FlowPhaseRepository extends BaseRepository<FlowPhase> {
}
