package com.butterfly.dts.admin.modules.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: BusinessLine
 * @description: 业务线
 * @author: pwh
 * @date: 2022/5/11
 **/
@Getter
@Setter
@TableName("t_system_business_line")
public class SystemBusinessLine extends BaseModel {

    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;
}
