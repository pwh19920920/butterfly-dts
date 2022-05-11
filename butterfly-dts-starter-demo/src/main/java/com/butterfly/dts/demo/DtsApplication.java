package com.butterfly.dts.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengweihuang
 */
@RestController
@SpringBootApplication
public class DtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtsApplication.class, args);
    }
}