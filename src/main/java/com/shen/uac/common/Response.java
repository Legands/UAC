package com.shen.uac.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName Response
 * Description 通用响应类
 * Author shaojun
 * Date 07/11/2019 17:16
 * Version 1.0
 **/
@Data
@AllArgsConstructor
public class Response<T> {
	private Integer code;

	private String response;

	private T data;
}
