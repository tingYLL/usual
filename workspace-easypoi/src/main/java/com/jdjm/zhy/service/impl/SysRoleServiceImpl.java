package com.jdjm.zhy.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jdjm.zhy.entity.SysRole;
import com.jdjm.zhy.mapper.SysRoleMapper;
import com.jdjm.zhy.service.SysRoleService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public void export() throws IOException {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("用户信息列表"); //表格标题
        exportParams.setSheetName("用户信息"); //sheet名
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, SysRole.class, sysRoles);

        FileOutputStream fos = new FileOutputStream("C:\\Users\\jdjm\\Desktop\\SysRole.xls");

        workbook.write(fos);
        fos.flush();

        fos.close();
        workbook.close();
        System.out.println("写入成功");
    }

}
