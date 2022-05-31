package com.butterfly.dts.admin.common.response;

import com.butterfly.dts.admin.common.vo.PagingVO;
import com.butterfly.dts.common.response.RespBody;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

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

    public static <T> PagingRespBody<Collection<T>> buildByPage(PagingVO<T> page) {
        return PagingRespBody.<Collection<T>>builder()
                .current(page.getCurrent())
                .size(page.getSize())
                .total(page.getTotal())
                .data(page.getRecords())
                .status(Status.SUCCESS)
                .build();
    }

    public static <T> PagingRespBody<Collection<T>> buildByData(Collection<T> data) {
        return PagingRespBody.<Collection<T>>builder()
                .size(data.size())
                .total(data.size())
                .data(data)
                .status(Status.SUCCESS)
                .build();
    }
}
