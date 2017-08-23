package com.family.sweety.modules.Login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.family.sweety.common.utils.JedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.family.sweety.modules.Login.entity.User;
import com.family.sweety.modules.Login.service.LoginService;
import redis.clients.jedis.Jedis;

@Controller
@RequestMapping(value = "/sys")
public class LoginController {


    @Autowired
    private LoginService service;



    @RequestMapping(value = "/login.php")
    public String login(Model model) {



        return "/modules/Login/index";

    }

    @RequestMapping(value = "/user.php")
    public @ResponseBody
    String user(Model model, String message, User user, HttpServletRequest request) {
        if (null == message || "" == message) {
            return "3";
        } else if ("register".equals(message)) {
            //注册
            String register = service.register(user);
            request.getSession().setAttribute("user", user);
            return register;
        } else if ("Login".equals(message)) {
            //登录

            Subject subject = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

            try {
                subject.login(token);
                Session session = subject.getSession();
                System.out.println("sessionId:" + session.getId());
                System.out.println("sessionHost:" + session.getHost());
                System.out.println("sessionTimeout:" + session.getTimeout());
                session.setTimeout(36000000);
                session.getHost();
                session.setAttribute("user", user);
                model.addAttribute("user", user);
                return "1";
            } catch (Exception e) {
                return "5";
            }


        } else {

            return "0";
        }


    }


    @RequestMapping(value = "/index.php")
    public String index(Model model, HttpServletRequest request) {
        return "/modules/sysindex/sysindex";
    }


    @RequestMapping(value = "unauthorized")
    public String unAuthorized() {


        return "modules/unAuthorized/unauthorized";
    }

    @RequestMapping(value = "sound.swf")
    public ModelAndView soundRedirect() {

        return new ModelAndView("redirect:http://www.pedrolamin.com.br/2008/sound.swf");
    }


    public static void main(String[] args) {

       Jedis jedis  = JedisUtil.getJedis();

       jedis.set("1","2");


        System.out.println(jedis.get("1"));


        JedisUtil.releaseResource(jedis);


    }

}
