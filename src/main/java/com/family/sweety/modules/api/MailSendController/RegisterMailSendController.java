package com.family.sweety.modules.api.MailSendController;

import com.family.sweety.common.constantUtils.MailConstantUtil.MailConstantUtil;
import com.family.sweety.common.utils.JedisUtil;
import com.family.sweety.common.utils.MailSendUtil;
import com.family.sweety.common.utils.UUIDUtils;
import com.family.sweety.common.utils.security.Base64Utils;
import com.family.sweety.modules.Login.entity.User;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by joseph on 2017/8/22.
 */

@Controller
@RequestMapping(value = "/api/mailSend.php")
public class RegisterMailSendController {

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
    public String sendMailForRegister(@PathVariable("user_email") String user_email, String timestamp, String username, String password) {

        String returnFlag = "0";


        if (null == registerUserMap) {

            registerUserMap = new HashMap<>(12);

        }

        registerUserMap.put("username", username);
        registerUserMap.put("password", password);


        String uuid = UUIDUtils.getTokenid();
        jedis.hmset(uuid, registerUserMap);


        jedis.expire(uuid, 180);




        String encodeParameter = Base64Utils.encode(uuid.getBytes());


        String aHref =  ("<html lang='zh-CN'><head ><meta charset='utf-8'>"

                + "</head><body>"

                + " "+MailConstantUtil.MAIL_CONTENT_BEFORE+"<a href='https://www.chinajava.top/api/mailSend.php/user_id/user_id=" + encodeParameter + "'>"+"注册认证"+"</a>"+ MailConstantUtil.MAIL_CONTENT_AFTER+"</body></html>");
        try {

            MailSendUtil.sendMail(MailConstantUtil.MAIL_TITLE,   aHref,user_email);


        } catch (Exception e) {

            e.printStackTrace();
            logger.warn("异常啦" + timestamp);
            returnFlag = "1";

        }

        return returnFlag;

    }


    /**
     * 用户注册邮箱点击确认函数
     *
     * @param user_id
     * @return
     */
    @RequestMapping(value = "/user_id.php")
    public String sendMailForRegister(String user_id, HttpServletRequest request) {

        String returnFlag = "注册成功";
        try {
            if (StringUtils.isNotBlank(user_id)) {

                String decodeStr = new String(Base64Utils.decode(user_id));





                    Map<String, String> registerInfoMap = jedis.hgetAll(decodeStr);

                    if (null != registerInfoMap) {

                        String userName = registerInfoMap.get("username");
                        String passWord = registerInfoMap.get("password");

                        //注册 保存数据库 登录

                        User user = new User();
                        user.setUsername(userName);
                        user.setPassword(passWord);
                        request.getSession().setAttribute("user",user);
                        return "redirect:/sys/user.php?username=" + userName + "&password=" + passWord;

                    } else {

                        returnFlag = "没有找到你的信息, 上帝大人";
                    }



            } else {

                returnFlag = "你是骗子, 根本没有给我参数~! 我都不知道你是谁";
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return returnFlag;

    }

}
