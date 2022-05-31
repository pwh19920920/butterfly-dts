package com.butterfly.dts.admin.modules.transform.repository;

import com.butterfly.dts.admin.common.repository.BaseRepository;
import com.butterfly.dts.admin.modules.transform.model.TransformMappingField;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TransformMappingFieldRepository
 * @description: TransformMappingFieldRepository
 * @author: pwh
 * @date: 2022/5/30
 **/
@Mapper
public interface TransformMappingFieldRepository extends BaseRepository<TransformMappingField> {
}
