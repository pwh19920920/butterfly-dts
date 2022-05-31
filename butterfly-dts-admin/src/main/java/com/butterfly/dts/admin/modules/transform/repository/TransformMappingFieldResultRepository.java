package com.butterfly.dts.admin.modules.transform.repository;

import com.butterfly.dts.admin.common.repository.BaseRepository;
import com.butterfly.dts.admin.modules.transform.model.TransformMappingFieldResult;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TransformMappingFieldResultRepository
 * @description: TransformMappingFieldResultRepository
 * @author: pwh
 * @date: 2022/5/30
 **/
@Mapper
public interface TransformMappingFieldResultRepository extends BaseRepository<TransformMappingFieldResult> {
}
