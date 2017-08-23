package com.family.sweety.modules.Login.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.family.sweety.modules.Login.entity.User;

@Service
@Transactional(readOnly = true)
public interface LoginService {


	@Transactional(readOnly=false)
	 String register(User user);
	
	
	 User login(User user);
	
	
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	 User  findUserByName(String username);
	
	
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	 User getByUserName(String userName);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	 Set<String> getRoles(String userName);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	 Set<String> getPermissions(String userName);



	Integer getUserByEmail(String email);


}
