package com.butterfly.dts.admin.modules.flow.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: FlowField
 * @description: 字段表
 * @author: pwh
 * @date: 2022/5/24
 **/
@Getter
@Setter
@TableName("t_flow_field")
public class FlowField extends BaseModel {

    /**
     * 参数路径
     */
    private String path;

    /**
     * 名称
     */
    private String name;

    /**
     * 业务线id
     */
    private Long systemBusinessLineId;

    /**
     * 是否敏感字段
     */
    private Boolean sensitive;
}
