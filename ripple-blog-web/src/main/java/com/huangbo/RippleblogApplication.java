package com.huangbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.huangbo.mapper")
@SpringBootApplication
public class RippleblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(RippleblogApplication.class, args);
    }

}
