package com.jdjm.zhy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName
public class TStudent {
    @TableId
    private Integer sid;
    private String sname;
    private Integer cid;

    public TStudent(String sname) {
        this.sname = sname;
    }
}
