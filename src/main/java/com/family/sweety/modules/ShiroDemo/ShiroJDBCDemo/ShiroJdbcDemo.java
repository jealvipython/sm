package com.family.sweety.modules.ShiroDemo.ShiroJDBCDemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Test;

public class ShiroJdbcDemo {
		
		public static void main(String[] args) {
			IniSecurityManagerFactory factory = new IniSecurityManagerFactory(
					"F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\ShiroDemo\\ShiroJDBCDemo\\shiro-jdbc.ini");

			SecurityManager securityManager = factory.getInstance();

			SecurityUtils.setSecurityManager(securityManager);

			Subject subject = SecurityUtils.getSubject();

			UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

			try {

				subject.login(token);
				System.out.println("登陆成功");

			} catch (AuthenticationException e) {

				System.out.println("登录失败");

			}

			subject.logout();

		}
	
	
	
}
