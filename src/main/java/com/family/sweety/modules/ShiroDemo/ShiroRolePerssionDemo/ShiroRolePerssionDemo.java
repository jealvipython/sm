package com.family.sweety.modules.ShiroDemo.ShiroRolePerssionDemo;

import org.junit.Assert;
import org.junit.Test;

import com.family.sweety.modules.ShiroDemo.ShiroRoleDemo.BaseTest;

public class ShiroRolePerssionDemo extends BaseTest {

	
	
	
	@Test
	public void shiroRolePerssionTest(){
		login("F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\ShiroDemo\\ShiroRolePerssionDemo\\shiro-role-perssion.ini","zhang","123");
		
		Assert.assertTrue(getSubject().isPermitted("user:create"));
		Assert.assertTrue(getSubject().isPermittedAll("user:create","user:update"));
	
		System.out.println(getSubject().isPermitted("user:view"));
	}
	
	
	@Test
	public void  shiroRolePermissionAll(){
		
		login("F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\ShiroDemo\\ShiroRolePerssionDemo\\shiro-role-perssion.ini","lisi","123");
		System.out.println(getSubject().isPermittedAll("user"));
	}
}
