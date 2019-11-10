package com.shen.uac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * ClassName SysRole
 * Description TODO
 * Author shaojun
 * Date 08/11/2019 11:17
 * Version 1.0
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRole {
	private Integer id;

	private String name;
}
