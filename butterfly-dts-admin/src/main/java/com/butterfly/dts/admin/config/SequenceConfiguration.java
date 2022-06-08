package com.butterfly.dts.admin.config;

import com.butterfly.dts.admin.common.senquce.Sequence;
import com.butterfly.dts.common.exceptions.ServiceException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: SenquceConfiguration
 * @description: SequenceConfiguration
 * @author: pwh
 * @date: 2022/6/1
 **/
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(SequenceConfiguration.SequenceProperties.class)
public class SequenceConfiguration {

    @NonNull
    private final SequenceProperties sequenceProperties;

    /**
     * id序列化
     *
     * @return 发号器
     */
    @Bean
    public Sequence sequence() {
        return new Sequence(sequenceProperties.getWorkerId(), sequenceProperties.getDataCenterId());
    }

    /**
     * 序列化
     */
    @Getter
    @Setter
    @ConfigurationProperties("dts.system.sequence")
    public static class SequenceProperties {

        private static final long MAX_WORKER_DATA_CENTER = 31;

        private static final long MIN_WORKER_DATA_CENTER = 0;

        private long workerId;

        private long dataCenterId;

        public void setWorkerId(long workerId) {
            if (workerId > MAX_WORKER_DATA_CENTER || workerId < MIN_WORKER_DATA_CENTER) {
                throw new ServiceException("workerId value is illegal, workerId availability ranges from 0 to 31");
            }
            this.workerId = workerId;
        }

        public void setDataCenterId(long dataCenterId) {
            if (dataCenterId > MAX_WORKER_DATA_CENTER || dataCenterId < MIN_WORKER_DATA_CENTER) {
                throw new ServiceException("dataCenterId value is illegal, workerId availability ranges from 0 to 31");
            }
            this.dataCenterId = dataCenterId;
        }
    }
}
