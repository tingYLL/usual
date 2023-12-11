package com.example.springaop.aop2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springaop.aop2.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
