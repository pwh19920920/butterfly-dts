package com.butterfly.dts.admin.modules.plugin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.butterfly.dts.admin.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: PluginParam
 * @description: 插件参数
 * @author: pwh
 * @date: 2022/5/24
 **/
@Getter
@Setter
@TableName("t_plugin_method_param")
public class PluginMethodParam extends BaseModel {

    /**
     * 方法id
     */
    private Long pluginMethodId;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 参数类型：占位符（也有可能是上一个方法的返回值），字符串，数字
     */
    private String paramType;

    /**
     * 输入类型：动态配置，固定配置
     * 固定配置即配置在方法之上，不会改变的
     */
    private String inputType;

    /**
     * 参数排序
     */
    private int paramSort;

    /**
     * 参数值，固定配置，会有一个值
     * 使用字符串存储，如果是数字，在输出模板还需要转成数字
     */
    private String paramValue;

    /**
     * 是否非空，默认都是不允许
     * 单身这个是否非空，只有在占位符的情况下才有意义，用于控制freemarker输出的时候在变量结尾假设感叹号
     * 例如：user.username!，代表该值可有可无，如果不加感叹号，默认策略将会报渲染错误
     */
    private Boolean notNull;

    /**
     * 业务线
     */
    private Long systemBusinessLineId;
}
