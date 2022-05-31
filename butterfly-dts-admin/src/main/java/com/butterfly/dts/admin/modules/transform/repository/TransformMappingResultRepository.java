package com.butterfly.dts.admin.modules.transform.repository;

import com.butterfly.dts.admin.common.repository.BaseRepository;
import com.butterfly.dts.admin.modules.transform.model.TransformMapping;
import com.butterfly.dts.admin.modules.transform.model.TransformMappingResult;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TransformMappingResultRepository
 * @description: TransformMappingResultRepository
 * @author: pwh
 * @date: 2022/5/30
 **/
@Mapper
public interface TransformMappingResultRepository extends BaseRepository<TransformMappingResult> {
}
