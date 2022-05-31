package com.butterfly.dts.admin.modules.transform.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: TransformMappingFieldMethodParam
 * @description: 映射字段方法参数表
 * @author: pwh
 * @date: 2022/5/25
 **/
@Getter
@Setter
@TableName("t_transform_mapping_field_method_param")
public class TransformMappingFieldMethodParam extends BaseModel {

    /**
     * 参数类型
     * 占位符：例如：${xxx}
     * 引用: 引用transformMappingFieldMethodId
     * 字符串: xxx
     */
    private String paramType;

    /**
     * 参数值
     */
    private String paramValue;

    /**
     * 参数排序
     */
    private int paramSort;

    /**
     * 插件方法id
     */
    private Long pluginMethodId;

    /**
     * 业务线
     */
    private Long systemBusinessLineId;

    /**
     * 映射接口ID
     */
    private Long transformMappingId;

    /**
     * 映射接口字段ID
     */
    private Long transformMappingFieldId;

    /**
     * 映射接口字段方法Id
     */
    private Long transformMappingFieldMethodId;
}
