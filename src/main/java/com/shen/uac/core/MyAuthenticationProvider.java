package com.shen.uac.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * ClassName MyAuthenticationProvider
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 14:42
 * Version 1.0
 **/
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserService userDetailsService;

	/**
	 * 自定义验证方式
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetails user = userDetailsService.loadUserByUsername(username);
		if(user.getPassword().equals(password)) {
			return new UsernamePasswordAuthenticationToken (username, null, user.getAuthorities());
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}

