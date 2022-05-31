package com.butterfly.dts.admin.modules.transform.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: TransformMappingFieldResult
 * @description: 映射字段映射结果
 * @author: pwh
 * @date: 2022/5/25
 **/
@Getter
@Setter
@TableName("t_transform_mapping_field_result")
public class TransformMappingFieldResult extends BaseModel {

    /**
     * 参数路径
     */
    private String outsidePath;

    /**
     * 外部类型
     * 字符串，默认值（字符串会在模板外加引号）
     */
    private String outsideParamType;

    /**
     * 映射结果
     */
    private String mappingResult;

    /**
     * 业务线
     */
    private Long systemBusinessLineId;

    /**
     * 映射接口ID
     */
    private Long transformMappingId;
}
