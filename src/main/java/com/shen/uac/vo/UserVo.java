package com.shen.uac.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName UserVo
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 17:14
 * Version 1.0
 **/

@Data
public class UserVo {
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	private String roleId;

	private Byte status;

	@NotNull
	@Min(1)
	private Integer pageNum;

	@NotNull
	@Min(0)
	private Integer pageSize;
}
