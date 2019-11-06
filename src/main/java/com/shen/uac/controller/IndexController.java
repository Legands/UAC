package com.shen.uac.controller;

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
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/index")
	public Object index(){
		return "Hello World";
	}
}
