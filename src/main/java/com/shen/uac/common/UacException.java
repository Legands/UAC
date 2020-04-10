package com.shen.uac.common;

/**
 * ClassName UacException
 * Description TODO
 * Author shaojun
 * Date 08/11/2019 10:05
 * Version 1.0
 **/
public class UacException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Integer code;

	public UacException(int code, String message){
		super(message);
		this.code = code;
	}

	public UacException(int code, String message, Throwable cause){
		super(message, cause);
		this.code = code;
	}

	public Integer getCode(){
		return this.code;
	}
}
