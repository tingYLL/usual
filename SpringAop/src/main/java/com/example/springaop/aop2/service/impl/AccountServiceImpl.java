package com.example.springaop.aop2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springaop.aop2.entity.Account;
import com.example.springaop.aop2.exception.JobException;
import com.example.springaop.aop2.mapper.AccountMapper;
import com.example.springaop.aop2.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService {


    public void aopAnnotationTest() {
        System.out.println("我是无注解方法,我要去调用有注解的方法");
        save();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save() {
        Account account = new Account("1003","25","5000");
        baseMapper.insert(account);
       throw new JobException("未知错误!");
    }
}
