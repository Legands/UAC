package com.shen.uac.dto;

import lombok.Data;

/**
 * ClassName Permission
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 17:31
 * Version 1.0
 **/
@Data
public class Permission {
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
