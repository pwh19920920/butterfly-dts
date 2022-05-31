package com.butterfly.dts.admin.modules.transform.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: TransformMapping
 * @description: 映射字段表
 * @author: pwh
 * @date: 2022/5/25
 **/
@Getter
@Setter
@TableName("t_transform_mapping_field")
public class TransformMappingField extends BaseModel {

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
     * 内部类型
     * 固定值，普通占位符，特殊占位符
     * 1. 普通占位符选字段即可
     * 2. 特殊占位符选配置公式
     */
    private String insideParamType;

    /**
     * 参数值
     * 1. 固定值，必须有值
     * 2. 普通占位符，填写FlowField的id
     * 3. 特殊占位符，此处为空，通过
     *
     */
    private String paramValue;

    /**
     * 业务线
     */
    private Long systemBusinessLineId;

    /**
     * 映射接口ID
     */
    private Long transformMappingId;
}
