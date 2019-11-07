package com.shen.uac.dao;

import com.shen.uac.dto.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
@org.apache.ibatis.annotations.Mapper
public interface UserDao extends Mapper<SysUser> {
	@Select ("select * from Sys_User where username = #{username}")
	public SysUser findByUserName(@Param ("username")String username);
}
