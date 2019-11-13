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
}
