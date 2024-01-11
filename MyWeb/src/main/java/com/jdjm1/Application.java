package com.jdjm1;

import com.jdjm1.service.TestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

//    @Bean
//    CommandLineRunner lookupTestService(TestService testService) {
//        return args -> {
//
//            // 1、test接口
//            testService.test();
//
//        };
//    }

}
