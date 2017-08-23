package com.family.sweety.modules.Login.dao;

import java.util.Set;

import com.family.sweety.common.utils.MyBatisDao;
import com.family.sweety.modules.Login.entity.User;

@MyBatisDao
public interface LoginDao {

	
	 void register(User user);
	 User  login(User user);
	
	
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
