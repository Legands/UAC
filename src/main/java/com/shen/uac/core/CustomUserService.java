package com.shen.uac.core;

import com.shen.uac.dao.PermissionDao;
import com.shen.uac.dao.UserDao;
import com.shen.uac.dto.Permission;
import com.shen.uac.dto.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName CustomUserService
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 17:25
 * Version 1.0
 **/
@Service
public class CustomUserService implements UserDetailsService {
	@Autowired
	UserDao userDao;
	@Autowired
	PermissionDao permissionDao;

	public UserDetails loadUserByUsername(String username) {
		SysUser user = userDao.findByUserName(username);
		if (user != null) {
			List<Permission> permissions = permissionDao.findByAdminUserId(user.getId ().intValue ());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<> ();
			for (Permission permission : permissions) {
				if (permission != null && permission.getName()!=null) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority (permission.getName());
					//1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
					grantedAuthorities.add(grantedAuthority);
				}
			}
			return new User (user.getUsername(), user.getPassword(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("admin: " + username + " do not exist!");
		}
	}
}
