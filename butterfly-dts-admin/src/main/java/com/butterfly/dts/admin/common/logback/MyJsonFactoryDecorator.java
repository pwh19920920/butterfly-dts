package com.butterfly.dts.admin.common.logback;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import net.logstash.logback.decorate.JsonFactoryDecorator;

/**
 *  @author peng
 */
public class MyJsonFactoryDecorator implements JsonFactoryDecorator {

    public MappingJsonFactory decorate(MappingJsonFactory factory) {
        // 禁用对非ascii码进行escape编码的特性
        factory.disable(JsonGenerator.Feature.ESCAPE_NON_ASCII);
        return factory;
    }
}