package com.family.sweety.common.FilterUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.family.sweety.modules.Login.entity.User;
import com.family.sweety.modules.Login.service.LoginService;

public class LoginPostFilter extends HttpServlet {

	@Autowired
	private LoginService loginService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String reqUserName = req.getParameter("username");
		String reqPassWord = req.getParameter("password");

		String forword = "";
		if (StringUtils.isNotBlank(reqUserName) && StringUtils.isNotEmpty(reqUserName)) {

			User user = loginService.findUserByName(reqUserName);

			if (null != user) {

				if (user.getPassword().equals(reqPassWord)) {
					req.getSession().setAttribute("user", user);

				} else {

					forword = "login.jsp";

				}

			} else {
				forword = "login.jsp";

			}

		} else {

			forword = "login.jsp";

		}
		
		if("".equals(forword)){
			
			
		}else{
			
			req.getRequestDispatcher(forword).forward(req, resp);
			
			
		}
		
		
	}
}
