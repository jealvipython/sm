package com.family.sweety.modules.api.MailSendController;

import com.family.sweety.common.constantUtils.BaseController;
import com.family.sweety.common.constantUtils.MailConstantUtil.MailConstantUtil;
import com.family.sweety.common.constantUtils.TableNameUtil;
import com.family.sweety.common.utils.JedisUtil;
import com.family.sweety.common.utils.Log.LogEntity;
import com.family.sweety.common.utils.MailSendUtil;
import com.family.sweety.common.utils.UUIDUtils;
import com.family.sweety.common.utils.security.Base64Utils;
import com.family.sweety.modules.Login.entity.User;
import com.family.sweety.modules.Login.service.LoginService;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by joseph on 2017/8/22.
 */

@Controller
@RequestMapping(value = "/api/mailSend.php")
public class RegisterMailSendController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(RegisterMailSendController.class);
    private Map<String, String> registerUserMap = null;
    private Jedis jedis = JedisUtil.getJedis();


    /**
     * 用户输入邮箱进行注册
     *
     * @param user_email
     * @param timestamp
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/{user_email}", method = RequestMethod.POST)
    @ResponseBody
    public String sendMailForRegister(@PathVariable("user_email") String user_email, String timestamp, String username, String password,HttpServletRequest request) {

        if(null!=username){
            User user = service.findUserByName(username);
            if(null!=user){

                return "201";
            }

        }
        if(null!=user_email){
            Integer count = service.getUserByEmail(user_email);

            if(1==count){

                return "401";
            }

        }






        String returnFlag = "0";


        if (null == registerUserMap) {

            registerUserMap = new HashMap<>(12);

        }

        registerUserMap.put("username", username);
        registerUserMap.put("password", password);
        registerUserMap.put("email", user_email);


        String uuid = UUIDUtils.getTokenid();
        jedis.hmset(uuid, registerUserMap);


        jedis.expire(uuid, 180);


        String encodeParameter = Base64Utils.encode(uuid.getBytes());


        String aHref = ("<html lang='zh-CN'><head ><meta charset='utf-8'>"

                + "</head><body>"

                + " " + MailConstantUtil.MAIL_CONTENT_BEFORE + "<a href='http://www.chinajava.top/api/mailSend.php/user_id.php?user_id=" + encodeParameter + "'>" + "注册认证" + "</a>" + MailConstantUtil.MAIL_CONTENT_AFTER + "</body></html>");
        try {

            MailSendUtil.sendMail(MailConstantUtil.MAIL_TITLE, aHref, user_email);

            LogEntity entity = new LogEntity();

            entity.setCreateDateTime(new Date());
            entity.setIsFlag("0");
            entity.setOpType(opType_2);
            entity.setUserIpAddress(request.getRemoteAddr());
            entity.setUserHostName(request.getRemoteHost());
            entity.setRelatedTableName(TableNameUtil.SM_USER_NAME);
            saveLogInfo(entity);


        } catch (Exception e) {

            e.printStackTrace();
            logger.warn("异常啦" + timestamp);
            returnFlag = "1";

        }

        return returnFlag;

    }


    @Autowired
    private LoginService service;

    /**
     * 用户注册邮箱点击确认函数
     *
     * @param user_id
     * @return
     */
    @RequestMapping(value = "/user_id.php")
    public String sendMailForRegister(String user_id, HttpServletRequest request, Model model) {

        String returnFlag = "出了一点问题";

        if (StringUtils.isNotBlank(user_id)) {
            String decodeStr="god";
            try{

                decodeStr  = new String(Base64Utils.decode(user_id));
            }catch (Exception e){

                e.printStackTrace();
                returnFlag="没有找到您的身份信息, 上帝大人";
                model.addAttribute("error",returnFlag);
                return returnFlag;
            }



            Map<String, String> registerInfoMap = jedis.hgetAll(decodeStr);

            if (null != registerInfoMap) {

                String userName = registerInfoMap.get("username");
                String passWord = registerInfoMap.get("password");
                String email = registerInfoMap.get("email");

                //注册 保存数据库 登录

                if (null != userName && null != passWord) {



                    User user =service.findUserByName(userName);

                    if(null==user){
                        user = new User();
                        user.setUsername(userName);
                        user.setPassword(passWord);
                        user.setEmail(email);
                        service.register(user);
                        LogEntity entity = new LogEntity();

                        entity.setCreateDateTime(new Date());
                        entity.setIsFlag("0");
                        entity.setOpType(opType_3);
                        entity.setUserIpAddress(request.getRemoteAddr());
                        entity.setUserHostName(request.getRemoteHost());
                        entity.setRelatedTableName(TableNameUtil.SM_USER_NAME);
                        saveLogInfo(entity);
                    }


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
                        return "redirect:/sys/index.php";
                    } catch (Exception e) {
                        returnFlag = "出了一点问题";

                    }


                } else {

                    returnFlag="时间过期~没有找到你的信息, 上帝大人.";

                }


            } else {
                returnFlag="时间过期~没有找到你的信息, 上帝大人.";

            }


        } else {

            returnFlag = "你是骗子, 根本没有给我参数~! 我都不知道你是谁";
        }

        model.addAttribute("error",returnFlag);
        return returnFlag;

    }

}
