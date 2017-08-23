package com.family.sweety.modules.ShiroDemo.PermissionTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.family.sweety.modules.ShiroDemo.ShiroRoleDemo.BaseTest;

public class PermissionDemo  extends BaseTest{

	
	
	@Test
	public void testPermissionTest(){
		
		Subject subject = login("F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\ShiroDemo\\PermissionTest\\shiro_permission.ini","zhangsan","123");
		
		
		/*System.out.println(subject.isPermitted("user:select")?"lisi有select权限":"lisi没有select权限");*/
		boolean[] permitted = subject.isPermitted("user:select","user:update","delete");
		System.out.println(permitted[0]);
		System.out.println(permitted[1]);
		System.out.println(permitted[2]);
		
		System.out.println(subject.isPermittedAll("user:select","user:update","user:delete"));
	
	
	
		
		
	}
	
}
