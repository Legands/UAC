package com.shen.uac.service;

import com.github.pagehelper.PageHelper;
import com.shen.uac.common.Response;
import com.shen.uac.dao.UserDao;
import com.shen.uac.dto.SysUser;
import com.shen.uac.vo.UserListVo;
import com.shen.uac.vo.UserVo;
import io.jsonwebtoken.lang.Collections;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

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

	public Response ajaxAddUser( UserVo vo){
		if (vo == null) {
			log.info ("入参为空");
			return new Response(1, "入参错误", null);
		}
		if (isExist (vo.getUsername ())){
			return new Response (2, "用户已存在，无法新建", null);
		}else {
			try {
				insertOneUser (vo);
			}catch (Exception e){
				log.error(e.getLocalizedMessage());
			}
			return new Response (0, "用户创建成功", null);
		}
	}

	public Response list(Response response, UserListVo vo){
		if (vo == null) {
			log.info ("入参为空");
			return new Response(1, "入参错误", null);
		}
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		if (vo.getUsername() != null){
			criteria.andEqualTo("username", vo.getUsername());
		}
		if (vo.getStatus() != null){
			criteria.andEqualTo("status", vo.getStatus());
		};
		int count = userDao.selectCountByExample(example);
//		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		RowBounds rowBounds = new RowBounds(vo.getPageNum(), vo.getPageSize());
//		List<SysUser> result = userDao.selectByExampleAndRowBounds(example, rowBounds);
		List<SysUser> result = userDao.selectByExample(example);
		response.setCode(0);
		response.setMsg("查询成功");
		response.setData(result);
		response.setDataSize(count);
		return response;
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
		user.setCreateUser (vo.getUsername ());
		user.setUpdateDate(new Date());
		user.setUpdateUser(vo.getUsername());
		return userDao.insertSelective (user);
	}
}
