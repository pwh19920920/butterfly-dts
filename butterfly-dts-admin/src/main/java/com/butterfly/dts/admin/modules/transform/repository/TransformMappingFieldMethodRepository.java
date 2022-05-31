package com.butterfly.dts.admin.modules.transform.repository;

import com.butterfly.dts.admin.common.repository.BaseRepository;
import com.butterfly.dts.admin.modules.transform.model.TransformMappingFieldMethod;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TransformMappingFieldMethodRepository
 * @description: TransformMappingFieldMethodRepository
 * @author: pwh
 * @date: 2022/5/30
 **/
@Mapper
public interface TransformMappingFieldMethodRepository extends BaseRepository<TransformMappingFieldMethod> {
}
