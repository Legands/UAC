package com.shen.uac.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> implements Serializable {
	private static final long serialVersionUID = 3166588541795826931L;

	private Integer code;

	private String msg;

	private T data;

	private Integer dataSize;

	public Response(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public Response(Integer code, String msg, T data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
