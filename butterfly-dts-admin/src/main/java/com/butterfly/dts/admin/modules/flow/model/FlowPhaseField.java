package com.butterfly.dts.admin.modules.flow.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: FlowPhaseField
 * @description: 流程阶段字段
 * @author: pwh
 * @date: 2022/5/24
 **/
@Getter
@Setter
@TableName("t_flow_phase_field")
public class FlowPhaseField extends BaseModel {

    /**
     * 业务线id
     */
    private Long systemBusinessLineId;

    /**
     * 阶段
     */
    private Long flowPhaseId;

    /**
     * Id
     */
    private Long flowFieldId;
}
