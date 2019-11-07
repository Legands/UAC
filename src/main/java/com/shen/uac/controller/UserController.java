package com.shen.uac.controller;

import com.shen.uac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName UserController
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 14:43
 * Version 1.0
 **/
@RestController
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping("/test1")
	public String test1() {
		return "test1";
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/test2")
	public String test2() {
		return "test2";
	}

	@RequestMapping()
	public Object register(){
		return null;
	}
}
