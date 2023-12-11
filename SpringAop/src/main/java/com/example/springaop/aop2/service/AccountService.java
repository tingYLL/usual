package com.example.springaop.aop2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springaop.aop2.entity.Account;

public interface AccountService extends IService<Account> {
    boolean save();

    void aopAnnotationTest();
}
