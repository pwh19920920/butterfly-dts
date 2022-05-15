package com.butterfly.dts.admin.common.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.ToString;

/**
 * @className: PagingVO
 * @description: PagingVO
 * @author: pwh
 * @date: 2022/5/15
 **/
@ToString
public class PagingVO<T> extends Page<T> {
}
