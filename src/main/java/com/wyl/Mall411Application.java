package com.wyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wyl.mall.dao")
@SpringBootApplication
public class Mall411Application {

    public static void main(String[] args) {
        SpringApplication.run(Mall411Application.class, args);
    }

}
