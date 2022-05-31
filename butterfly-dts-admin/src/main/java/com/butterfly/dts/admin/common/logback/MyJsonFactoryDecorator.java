package com.butterfly.dts.admin.common.logback;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import net.logstash.logback.decorate.JsonFactoryDecorator;

/**
 * @author peng
 */
public class MyJsonFactoryDecorator implements JsonFactoryDecorator {
 
    @Override
    public MappingJsonFactory decorate(MappingJsonFactory factory) {
        return factory;
    }
}