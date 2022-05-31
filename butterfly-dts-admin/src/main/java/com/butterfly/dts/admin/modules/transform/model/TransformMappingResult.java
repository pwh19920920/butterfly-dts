package com.butterfly.dts.admin.modules.transform.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: TransformMapping
 * @description: 映射表
 * @author: pwh
 * @date: 2022/5/25
 **/
@Getter
@Setter
@TableName("t_transform_mapping_result")
public class TransformMappingResult extends BaseModel {

    /**
     * 映射结果
     */
    private String mappingResult;

    /**
     * 业务线ID
     */
    private Long systemBusinessLineId;

    /**
     * 业务线Code
     */
    private String systemBusinessLineCode;

    /**
     * 映射接口ID
     */
    private Long transformMappingId;

    /**
     * 映射接口Code
     */
    private String transformMappingCode;
}
