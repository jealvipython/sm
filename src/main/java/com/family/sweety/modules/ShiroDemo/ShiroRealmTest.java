package com.family.sweety.modules.ShiroDemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

public class ShiroRealmTest {

	
	
	
	@Test
	public void   shiroRealTest(){
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\ShiroDemo\\shiro-Realm.ini");
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		
		UsernamePasswordToken token = new UsernamePasswordToken("mei", "123");
		
		try{
			
			subject.login(token);
			
		}catch(AuthenticationException e){
			
			System.out.println("用户名密码错误");
		}
		
		Assert.assertEquals(true,subject.isAuthenticated());
		subject.logout();
		
	}
	
	
	
	
	
	
	
/**
 * 多Realm 测试	
 * @param config
 * 
 * 
 * FirstSuccessfulStrategy：只要有一个Realm验证成功即可，只返回第一个Realm身份验证成功的认证信息，其他的忽略；

AtLeastOneSuccessfulStrategy：只要有一个Realm验证成功即可，和FirstSuccessfulStrategy不同，返回所有Realm身份验证成功的认证信息；

AllSuccessfulStrategy：所有Realm验证成功才算成功，且返回所有Realm身份验证成功的认证信息，如果有一个失败就失败了。



ModularRealmAuthenticator默认使用AtLeastOneSuccessfulStrategy策略。

 

假设我们有三个realm：

myRealm1： 用户名/密码为zhang/123时成功，且返回身份/凭据为zhang/123；

myRealm2： 用户名/密码为wang/123时成功，且返回身份/凭据为wang/123；

myRealm3： 用户名/密码为zhang/123时成功，且返回身份/凭据为zhang@163.com/123，和myRealm1不同的是返回时的身份变了；
 */
	
	
	
	
	
	
	
	
	
	
	
	
	//通用化登录逻辑
	
	
	public void login(String config){
		
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory(config);
		
		SecurityManager securityManager = factory.getInstance();
		
		
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("mei","123");
		
		
		try{
			
			
			
			subject.login(token);
		}catch(AuthenticationException e){
			
			System.out.println("登录失败");
			
		}
		
		
	}
	
	
	@Test
	public void testAllSuccessStrategyWithSuccess(){
		
		login("F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\ShiroDemo\\shiro-Realm.ini");
		
		Subject subject = SecurityUtils.getSubject();
		
		PrincipalCollection collection = subject.getPrincipals();
		Assert.assertEquals(2, collection.asList().size());//断言 为2时,OK   即  principal中包含了 mei \123  和 mei@163.com \123
		
		
	}
	
	
	
	
}
