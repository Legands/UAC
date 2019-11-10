package com.shen.uac.dao;


import com.shen.uac.dto.SysRole;
import com.shen.uac.dto.SysUser;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
@org.apache.ibatis.annotations.Mapper
public interface RoleDao extends Mapper<SysRole> {

}
