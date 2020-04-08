package com.shen.uac.dao;


import com.shen.uac.dto.SysRole;
import com.shen.uac.dto.SysUser;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface RoleDao extends Mapper<SysRole> {

}
