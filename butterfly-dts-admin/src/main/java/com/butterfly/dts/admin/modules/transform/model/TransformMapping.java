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
@TableName("t_transform_mapping")
public class TransformMapping extends BaseModel {

    /**
     * 方法code
     */
    private String code;

    /**
     * 方法名
     */
    private String name;

    /**
     * 业务线
     */
    private Long systemBusinessLineId;

    /**
     * 流程阶段
     */
    private Long flowPhaseId;
}
