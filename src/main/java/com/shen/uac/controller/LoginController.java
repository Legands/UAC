package com.shen.uac.controller;

import com.shen.uac.common.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName IndexController
 * Description TODO
 * Author shaojun
 * Date 06/11/2019 18:34
 * Version 1.0
 **/

@RestController
//@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/index")
	public Object index(){
		return "Hello World";
	}

	@GetMapping("/login/{status}")
	public Object login(@PathVariable String status) {
		Response response = new Response ();
		if("auth".equals(status)){
			response.setCode (1);
			response.setMsg ("没有登录");
		}
		if("fail".equals(status)){
			response.setCode (2);
			response.setMsg ("登录失败");
		}
		if("success".equals(status)){
			response.setCode (3);
			response.setMsg ("登录成功");
		}
		if("logout".equals(status)){
			response.setCode (3);
			response.setMsg ("注销成功");
		}
		return response;
	}
}
