package com.shen.uac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName User
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 16:30
 * Version 1.0
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String nickName;
	private String icon;
	private String qrCode;
	private String fullName;
	private Date birthday;
	private Byte gender;
	private String nation;
	private String motherTongue;
	private String address;
	private String phoneNumber;
	private Long idCard;
	private Date lastLoginTime;
	private String lastLoginIp;
	private String openId;
	private String company;
	private String businessNumber;
	private String professionalTitle;
	private String email;
	private String socialAccount;
	private Byte status;
	private Date createDate;
	private String createUser;
	private Date updateDate;
	private String updateUser;
}
