package com.shen.uac.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName UacExceptionHandler
 * Description TODO
 * Author shaojun
 * Date 08/11/2019 10:08
 * Version 1.0
 **/
@ControllerAdvice
public class UacExceptionHandler {

	@ExceptionHandler(UacException.class)
	@ResponseBody
	public Object onUacException(UacException ex, HttpServletRequest req, HttpServletResponse resp){
		return new Response<Object> (ex.getCode (), ex.getMessage ());
	}

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object onException(Exception ex, HttpServletRequest req, HttpServletResponse resp){
		return new Response (500, ex.getMessage ());
	}
}
