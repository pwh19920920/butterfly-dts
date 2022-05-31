package com.butterfly.dts.admin.modules.plugin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: PluginMethod
 * @description: 插件方法
 * @author: pwh
 * @date: 2022/5/24
 **/
@Getter
@Setter
@TableName("t_plugin_method")
public class PluginMethod extends BaseModel {

    /**
     * 前缀id
     */
    private Long prefixId;

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
}
