package com.family.sweety.modules.ShiroDemo.ShiroRoleDemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

public abstract class BaseTest {

	
	@After
	public void testDown(){
		
		ThreadContext.unbindSubject();  //退出时,解除绑定subject到线程, 不然会影响下一次的test
	}
	
	
	protected Subject login(String config,String username,String password){
		
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory(config);
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		try{
			
			
			subject.login(token);
			return subject;
			
		}catch(AuthenticationException e){
			
			System.out.println("登录失败");
			return null;
		}
		
		
	}
	public Subject getSubject(){
		
		return SecurityUtils.getSubject();
	}
}
