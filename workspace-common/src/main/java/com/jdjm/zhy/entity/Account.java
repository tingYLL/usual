package com.jdjm.zhy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("account")
@AllArgsConstructor
public class Account {
    @TableId
    private String id;
    private String accountno;
    private String balance;
}
