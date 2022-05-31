package com.butterfly.dts.admin.modules.transform.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: TransformMappingMethod
 * @description: 映射字段方法表
 * @author: pwh
 * @date: 2022/5/25
 **/
@Getter
@Setter
@TableName("t_transform_mapping_field_method")
public class TransformMappingFieldMethod extends BaseModel {

    /**
     * 内部排序
     */
    private int sort;

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
}
