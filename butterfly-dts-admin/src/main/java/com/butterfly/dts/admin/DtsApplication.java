package com.butterfly.dts.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengweihuang
 */
@SpringBootApplication
@MapperScan("com.butterfly.dts.admin")
public class DtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtsApplication.class, args);
    }
}