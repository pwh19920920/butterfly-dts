package com.butterfly.dts.admin.common.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @className: BaseModel
 * @description: BaseModel
 * @author: pwh
 * @date: 2022/5/15
 **/
@Getter
@Setter
public class BaseModel {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 修改时间
     */
    private Date updatedAt;

    /**
     * 删除标记
     */
    private Integer deleted;
}
