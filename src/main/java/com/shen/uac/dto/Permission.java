package com.shen.uac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName Permission
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 17:31
 * Version 1.0
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission implements Serializable {
	private static final long serialVersionUID = -8752685601145159399L;

	private Integer id;

	private String name;
	/**
	 * 权限描述
	 */
	private String description;

	/**
	 * 授权链接
	 */
	private String url;

	private Integer pid;
}
