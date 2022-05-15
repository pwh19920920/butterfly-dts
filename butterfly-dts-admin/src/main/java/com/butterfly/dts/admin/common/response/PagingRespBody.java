package com.butterfly.dts.admin.common.response;

import com.butterfly.dts.admin.common.vo.PagingVO;
import com.butterfly.dts.common.response.RespBody;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @className: PagingRespBody
 * @description: PagingRespBody
 * @author: pwh
 * @date: 2022/5/15
 **/
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class PagingRespBody<T> extends RespBody<T> {

    private long total;

    private long size;

    private long current;

    public static <T> PagingRespBody<List<T>> buildByPage(PagingVO<T> page) {
        return PagingRespBody.<List<T>>builder()
                .current(page.getCurrent())
                .size(page.getSize())
                .total(page.getTotal())
                .data(page.getRecords())
                .status(200)
                .build();
    }
}
