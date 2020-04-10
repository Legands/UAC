package com.shen.uac.service;

import com.shen.uac.common.Final;
import com.shen.uac.common.Response;
import com.shen.uac.common.Source;
import com.shen.uac.dao.FinalDao;
import com.shen.uac.dao.SourceDao;
import com.shen.uac.dao.UserDao;
import com.shen.uac.dto.SysUser;
import com.shen.uac.vo.UserListVo;
import com.shen.uac.vo.UserVo;
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

	@Autowired
	SourceDao sourceDao;

	@Autowired
	FinalDao finalDao;

	public Response<?> ajaxAddUser( UserVo vo){
		if (vo == null) {
			log.info ("入参为空");
			return new Response<Object>(1, "入参错误", null);
		}
		if (isExist (vo.getUsername ())){
			return new Response<Object> (2, "用户已存在，无法新建", null);
		}else {
			try {
				insertOneUser (vo);
			}catch (Exception e){
				log.error(e.getLocalizedMessage());
			}
			return new Response<Object> (0, "用户创建成功", null);
		}
	}

	public Response<Object> list(Response<Object> response, UserListVo vo){
		if (vo == null) {
			log.info ("入参为空");
			return new Response<Object>(1, "入参错误", null);
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

	public void operate(){
		List<Source> sourceList = sourceDao.selectAll ();
		for (Source source : sourceList){
//			if (StringUtil.isBlank (source.get版权开始时间 ()))
			String name = source.get片名 ();
			Example example = new Example (Final.class);
			example.createCriteria ().andEqualTo ("所属剧集名", name).orEqualTo ("频道名", name);
			Final f = new Final ();
			f.set百科类型 (source.get百科类型 ());
			f.set获取方式 (source.get获取方式 ());
			f.set版权开始时间 (source.get版权开始时间 ());
			f.set版权结束时间 (source.get版权结束时间 ());
			f.set导演 (source.get导演 ());
			f.set演员 (source.get演员 ());
			f.set我方是否独家 (source.get我方是否独家 ());
			try {
				finalDao.updateByExampleSelective (f, example);
			}catch (Exception e){
				continue;
			}
		}
	}
}
