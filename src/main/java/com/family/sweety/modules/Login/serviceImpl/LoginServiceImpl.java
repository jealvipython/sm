package com.family.sweety.modules.Login.serviceImpl;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.family.sweety.common.utils.BaseService;
import com.family.sweety.modules.Login.dao.LoginDao;
import com.family.sweety.modules.Login.entity.User;
import com.family.sweety.modules.Login.service.LoginService;

@Service
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService{
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LoginDao dao;

	@Transactional(readOnly=false)
	public String register(User user){
		if(null==user){
			
			logger.warn("用户登录   实体类user为null");
			return "0";
		}else if(null==user.getUsername()||"".equals(user.getUsername())){
			
			logger.warn("用户登录   实体类user用户名为空");
			return "0";
		}else if(null==user.getPassword()||"".equals(user.getPassword())){
			logger.warn("用户登录   实体类user用户名为空");
			return "0";
			
			
		}else{
			user.setCreateTime(new Date());
			
			dao.register(user);
			return "2";
		}
}
	
	
	public User login(User user){
		
		if(null!=user ){
			
			
			return	dao.login(user);
			
		}else{
			
			return null;
		}
		
	}
	
	
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public User  findUserByName(String username){
		if(StringUtils.isNotBlank(username)){
			
		return dao.findUserByName(username);
			
		}else{
			
			
			return null;
		}
		
	}

	public User getByUserName(String userName) {
		return dao.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		return dao.getRoles(userName);
	}

	public Set<String> getPermissions(String userName) {
		return dao.getPermissions(userName);
	}
}
