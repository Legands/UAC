package com.shen.uac.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * ClassName Response
 * Description 通用响应类
 * Author shaojun
 * Date 07/11/2019 17:16
 * Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
	private Integer code;

	private String msg;

	private T data;

	public Response(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}
}
