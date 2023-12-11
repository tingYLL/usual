package com.example.springaop.aop2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springaop.aop2.entity.Account;
import com.example.springaop.aop2.exception.JobException;
import com.example.springaop.aop2.mapper.AccountMapper;
import com.example.springaop.aop2.service.AccountService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService {


    //调用同一个类中的方法，同一个类中的方法不会经过AOP的代理，而 @Transactional 是通过 Spring AOP 来实现的，因此在这种情况下，事务注解不会生效。
    public void aopAnnotationTest() {
        System.out.println("我是无注解方法,我要去调用有注解的方法");
        save();
    }



    public void aopAnnotationTest2() {
        System.out.println("我是无注解方法,我要去调用有注解的方法");
        Object o = AopContext.currentProxy();
        ( (AccountService) o).aopAnnotationTest();
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
