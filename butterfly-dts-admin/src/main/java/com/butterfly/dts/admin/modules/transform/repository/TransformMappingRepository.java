package com.butterfly.dts.admin.modules.transform.repository;

import com.butterfly.dts.admin.common.repository.BaseRepository;
import com.butterfly.dts.admin.modules.transform.model.TransformMapping;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TransformMappingRepository
 * @description: TransformMappingRepository
 * @author: pwh
 * @date: 2022/5/30
 **/
@Mapper
public interface TransformMappingRepository extends BaseRepository<TransformMapping> {
}
