package com.shen.uac;

import com.shen.uac.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName WebSecurityConfig
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 14:41
 * Version 1.0
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationProvider provider;// 自定义的AuthenticationProvider

	@Autowired
	private CustomUserService customUserService;
	@Bean
	public PasswordEncoder myPasswordEncoder() {
		return new MyPasswordEncoder ();//自定义的加密工具
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()//配置权限
				.anyRequest().authenticated()//任意请求需要登录
				.and()
				.formLogin()//开启formLogin默认配置
				.loginPage("/login/auth").permitAll()//请求时未登录跳转接口
				.failureUrl("/login/fail")//用户密码错误跳转接口
				.defaultSuccessUrl("/login/success",true)//登录成功跳转接口
				.loginProcessingUrl("/login")//post登录接口，登录验证由系统实现
				.usernameParameter("username")	//要认证的用户参数名，默认username
				.passwordParameter("password")	//要认证的密码参数名，默认password
				.and()
				.logout()//配置注销
				.logoutUrl("/logout")//注销接口
				.logoutSuccessUrl("/login/logout").permitAll()//注销成功跳转接口
				.deleteCookies("myCookie") //删除自定义的cookie
				.and()
				.csrf().disable()
				.addFilter(new JWTLoginFilter (authenticationManager()))
				.addFilter(new JWTAuthenticationFilter (authenticationManager()));
	}

//	@Override
//	public void configure(WebSecurity web) {
////		web.ignoring ().antMatchers ("/static/**");
//	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
//		auth.userDetailsService(userInMemoDetailsService());
		auth.userDetailsService (customUserService);
	}

	@Bean
	public UserDetailsService userInMemoDetailsService() {
		InMemoryUserDetailsManager iud = new InMemoryUserDetailsManager();
		Collection<GrantedAuthority> adminAuth = new ArrayList<> ();
		adminAuth.add(new SimpleGrantedAuthority ("ROLE_ADMIN"));
		iud.createUser(new User ("shaojun", "2411811ss", adminAuth));
		return iud;
	}

}
