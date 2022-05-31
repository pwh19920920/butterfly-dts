package com.butterfly.dts.admin.modules.plugin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: Prefix
 * @description: 插件前缀表
 * @author: pwh
 * @date: 2022/5/24
 **/
@Getter
@Setter
@TableName("t_plugin_prefix")
public class PluginPrefix extends BaseModel {

    /**
     * 前缀code
     */
    private String code;

    /**
     * 前缀名称
     */
    private String name;

    /**
     * 业务线id
     */
    private Long systemBusinessLineId;
}
