package com.shen.uac.service;

import com.shen.uac.common.Response;
import com.shen.uac.dao.UserDao;
import com.shen.uac.dto.SysUser;
import com.shen.uac.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName UserService
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 17:15
 * Version 1.0
 **/
@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger (UserService.class);

	@Autowired
	UserDao userDao;

	public Response ajaxAddUser(Response response, UserVo vo){
		if (vo == null) {
			log.info ("入参为空");
			return response;
		}
		if (isExist (vo.getUserName ())){
			return new Response (2, "用户已存在，无法新建", null);
		}else {
			insertOneUser (vo);
			return new Response (0, "用户创建成功", null);
		}
	}

	public boolean isExist(String userName){
		SysUser exist = userDao.findByUserName (userName);

		return exist == null ? false : true;
	}

	private Integer insertOneUser(UserVo vo){
		SysUser user = new SysUser ();
		BeanUtils.copyProperties (vo, user);
		user.setStatus ((byte) 0);
		user.setCreateDate (new Date ());
		user.setCreateUser (vo.getUserName ());
		return userDao.insertSelective (user);
	}
}
