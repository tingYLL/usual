package com.jdjm.zhy;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.jdjm.zhy.mapper")
public class ZhySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhySpringBootApplication.class, args);
    }
}
