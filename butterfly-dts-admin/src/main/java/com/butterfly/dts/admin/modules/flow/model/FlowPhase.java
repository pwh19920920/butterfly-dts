package com.butterfly.dts.admin.modules.flow.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: FlowPhase
 * @description: 流程阶段
 * @author: pwh
 * @date: 2022/5/24
 **/
@Getter
@Setter
@TableName("t_flow_phase")
public class FlowPhase extends BaseModel {

    /**
     * code
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 业务线id
     */
    private Long systemBusinessLineId;
}
