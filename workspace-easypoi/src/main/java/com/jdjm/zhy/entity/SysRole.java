package com.jdjm.zhy.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


@Data
@TableName("sys_role")
@ExcelTarget("role")
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Excel(name = "角色姓名",width=30.0)
	@TableField("role_name")
	private String roleName;

	@Excel(name = "角色编码",width=30.0)
	@TableField("role_code")
	private String roleCode;

	@Excel(name = "描述",width=30.0)
	@TableField("description")
	private String description;

}

