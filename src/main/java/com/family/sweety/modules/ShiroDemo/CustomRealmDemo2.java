package com.family.sweety.modules.ShiroDemo;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class CustomRealmDemo2  implements Realm{

	@Override
	public String getName() {
		return "myRealmName";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		//仅支持UserNamePasswordToken类型的Token
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String username =(String)token.getPrincipal();//得到用户名
		String password = new String((char[])token.getCredentials());//得到密码
		
		if(!"zhang".equals(username)){
			
			System.out.println("用户名错误");
			throw new UnknownAccountException();
		}
		
		if(!"123".equals(password)){
			System.out.println("密码错误");
			throw new UnknownAccountException();
		}
		
		//如果认证成功, 则返回一个AuthenticationInfo的实现
		return  new SimpleAuthenticationInfo(username, password, getName());
		
		
	}

}
