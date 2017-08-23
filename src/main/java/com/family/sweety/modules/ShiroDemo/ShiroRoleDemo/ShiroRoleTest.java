package com.family.sweety.modules.ShiroDemo.ShiroRoleDemo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ShiroRoleTest extends  BaseTest {

	
	
	@Test
	public void testRole(){
		
		login("F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\ShiroDemo\\ShiroRoleDemo\\shiro-role.ini","zhang","123");
		
		//是否有角色role1
		Assert.assertTrue(getSubject().hasRole("role1"));
		//是否有角色role2,3
		Assert.assertTrue(getSubject().hasAllRoles(Arrays.asList("role1","role2")));
		//是否有角色 role1,2,3
		boolean roles[] = getSubject().hasRoles(Arrays.asList("role1","role2","role3"));
		
		Assert.assertEquals(true,(roles[0]));
		Assert.assertEquals(true,roles[1]);
		Assert.assertEquals(false,roles[2]);
		
	}
}
