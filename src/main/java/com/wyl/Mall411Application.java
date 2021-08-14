package com.wyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.wyl.mall.dao")
@SpringBootApplication
@EnableCaching
public class Mall411Application {

    public static void main(String[] args) {
        SpringApplication.run(Mall411Application.class, args);
    }

}
