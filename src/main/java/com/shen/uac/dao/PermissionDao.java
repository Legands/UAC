package com.shen.uac.dao;

import com.shen.uac.dto.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface PermissionDao extends Mapper<Permission> {

	@Select ("SELECT * from Sys_permission ;")
	public List<Permission> findAll();

	@Select (" SELECT\n" +
			"\tp.* \n" +
			"FROM\n" +
			"\tSys_User u\n" +
			"\tLEFT JOIN Sys_role_user sru ON u.id = sru.Sys_User_id\n" +
			"\tLEFT JOIN Sys_Role r ON sru.Sys_Role_id = r.id\n" +
			"\tLEFT JOIN Sys_permission_role spr ON spr.role_id = r.id\n" +
			"\tLEFT JOIN Sys_permission p ON p.id = spr.permission_id \n" +
			"WHERE\n" +
			"\tu.id = #{userId}")
	public List<Permission> findByAdminUserId(@Param ("userId")Integer userId);
}
