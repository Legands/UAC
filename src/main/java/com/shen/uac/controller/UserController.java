package com.shen.uac.controller;

import com.shen.uac.common.Response;
import com.shen.uac.common.UacException;
import com.shen.uac.service.UserService;
import com.shen.uac.vo.UserListVo;
import com.shen.uac.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName UserController
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 14:43
 * Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@PreAuthorize("hasAuthority('ROLE_COMMON')")
	@RequestMapping("/test1")
	public String test1() {
		return "test1";
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/test2")
	public String test2() {
		return "test2";
	}

	/**
	 * @desc 用户注册接口，新用户默认是ROLE_USER角色
	 * @param vo
	 * @param br
	 * @return
	 */
	@PostMapping("/register")
	public Object register(@RequestBody @Validated UserVo vo, BindingResult br){
		if (br.hasErrors ()){
			return new UacException (1, br.getGlobalError ().toString ());
		}
		return service.ajaxAddUser (vo);
	}

	/**
	 * 用户分页查询接口
	 * @param vo
	 * @param br
	 * @return
	 */
	@GetMapping("/list")
	public Object listAll(@Validated UserListVo vo, BindingResult br){
		if (br.hasErrors ()){
			return new UacException (1, br.getGlobalError ().toString ());
		}
		Response response = new Response();
		return service.list (response, vo);
	}

	/**
	 * 用户名验证接口
	 * @param username
	 * @return
	 */
	@GetMapping("/checkUsername")
	public Object checkUsername(String username){
		Response response = new Response ();
		boolean exist = service.isExist (username);
		response.setCode (exist ? 1 : 0);
		response.setMsg (exist ? "用户已存在，不可创建" : "用户不存在，可以创建");
		return response;
	}

	@GetMapping("/operate")
	public Object operate(){
		service.operate ();
		return "成功";
	}
}
