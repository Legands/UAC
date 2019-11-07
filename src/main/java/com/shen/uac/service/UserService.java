package com.shen.uac.service;

import com.shen.uac.WebSecurityConfig;
import com.shen.uac.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName UserService
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 17:15
 * Version 1.0
 **/
@Service
public class UserService {
	@Autowired
	WebSecurityConfig config;
	public Response ajaxAddUser(){
		return new Response (1, "", null);
	}
}
