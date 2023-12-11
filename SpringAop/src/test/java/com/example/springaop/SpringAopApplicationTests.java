package com.example.springaop;

import com.example.springaop.aop2.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {
    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
//        accountService.save();
        accountService.aopAnnotationTest();
    }

    @Test
    void test2(){
        accountService.aopAnnotationTest2();
    }
}
