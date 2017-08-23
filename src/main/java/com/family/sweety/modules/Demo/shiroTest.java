package com.family.sweety.modules.Demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author 梅浩
 * @2016年12月15日
 * @mdn美得你
 * @author_phone : 18610507472
 * @ClassInfo:shiro身份验证
 * 
 * 
 * 
 * 						2.1、首先通过new
 *                      IniSecurityManagerFactory并指定一个ini配置文件来创建一个SecurityManager工厂；
 * 
 *                      2.2、接着获取SecurityManager并绑定到SecurityUtils，这是一个全局设置，
 *                      设置一次即可；
 * 
 *                      2.3、通过SecurityUtils得到Subject，其会自动绑定到当前线程；
 *                      如果在web环境在请求结束时需要解除绑定；然后获取身份验证的Token，如用户名/密码；
 * 
 *                      2.4、调用subject.login方法进行登录，其会自动委托给SecurityManager.
 *                      login方法进行登录；
 * 
 *                      2.5、如果身份验证失败请捕获AuthenticationException或其子类，常见的如：
 *                      DisabledAccountException（禁用的帐号）、LockedAccountException（
 *                      锁定的帐号）、UnknownAccountException（错误的帐号）、
 *                      ExcessiveAttemptsException（登录失败次数过多）、
 *                      IncorrectCredentialsException
 *                      （错误的凭证）、ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；
 *                      对于页面的错误消息展示，最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，
 *                      防止一些恶意用户非法扫描帐号库；
 * 
 *                      2.6、最后可以调用subject.logout退出，其会自动委托给SecurityManager.
 *                      logout方法退出。
 * 
 */
public class shiroTest {

	@Test
	public void testShiro() {

		// 获取securityManager 工厂,使用init的配置文件初始化securityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("F:\\github\\Demo\\sm\\src\\main\\java\\com\\family\\sweety\\modules\\Demo\\user.ini");

		// 获取securityManager实例
		SecurityManager securityManager = factory.getInstance();

		// 绑定给SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);

		// 得到subject 并 创建一个包含用户名 密码 的身份验证token (即用户身份/凭证) ,重载方法中还有是否记住我, 及登录人ip
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("lisi", "123");

		try {

			subject.login(token);

		} catch (AuthenticationException e) {

			e.printStackTrace();
			System.out.println("认证失败");

		}

		Assert.assertEquals(true, subject.isAuthenticated());// 断言 用户已经登录

		subject.logout();
	}
}
