package com.jdjm.zhy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jdjm.zhy.entity.SysRole;

import java.io.IOException;

public interface SysRoleService extends IService<SysRole> {
    public void export() throws IOException;
}
