package com.butterfly.dts.common.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pengweihuang
 */
@Getter
@Setter
@Data
@Builder
public class Template {
    private String name;
    private String template;
}