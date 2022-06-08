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
     * 方法code，方法的英文名
     */
    private String code;

    /**
     * 方法名
     */
    private String name;

    /**
     * 如果前缀类型是脚本，次数需要保存具体的js代码
     */
    private String script;

    /**
     * 业务线
     */
    private Long systemBusinessLineId;
}
