package com.butterfly.dts.admin.modules.system.repository;

import com.butterfly.dts.admin.common.repository.BaseRepository;
import com.butterfly.dts.admin.modules.system.model.SystemBusinessLine;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: BusinessLineRepository
 * @description: 业务线Repository
 * @author: pwh
 * @date: 2022/5/11
 **/
@Mapper
public interface SystemBusinessLineRepository extends BaseRepository<SystemBusinessLine> {

}
