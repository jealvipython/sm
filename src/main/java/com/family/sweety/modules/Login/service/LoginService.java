package com.family.sweety.modules.Login.service;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.family.sweety.common.utils.BaseService;
import com.family.sweety.modules.Login.dao.LoginDao;
import com.family.sweety.modules.Login.entity.User;

@Service
@Transactional(readOnly = true)
public interface LoginService {


	@Transactional(readOnly=false)
	public String register(User user);
	
	
	public User login(User user);
	
	
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public User  findUserByName(String username);
	
	
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
}
