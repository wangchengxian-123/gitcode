package com.aaa.controller;

import com.aaa.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author WCX
 * @data 2020/6/19 11:42
 * @describe
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @PostMapping("/")
    public User reg(User user) {
        return user;
    }


    @GetMapping("/login")
    public String login(User user) {
        //获取Subject
        Subject currentUser= SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            //用户名密码的令牌信息
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassWord());
            //记住我
            token.setRememberMe(true);
            try {
                //调用登录方法：将token ------------->委托给安全管理器进行认证--------------------->进入认证器，调用Realm获取用户信息进行匹配
                currentUser.login(token);

                //该位置手动的设置session
                               Session userSession = currentUser.getSession();
                userSession.setAttribute("user",user);

                         /*   Collection<Object> keys = userSession.getAttributeKeys();

//                            DefaultSubjectContext

                            for (Object key : keys) {
                                System.out.println(key);
                            }*/

//                return "forward:/user/queryAll";
                return "lll";
            } catch (UnknownAccountException uae) { //账号不存在
                throw new UnknownAccountException("账号不存在");
            } catch (IncorrectCredentialsException ice) {//密码不匹配
                throw new IncorrectCredentialsException("密码不匹配");
            } catch (LockedAccountException lae) {//账户锁定
                throw new LockedAccountException("账户锁定异常");
            } catch (ExcessiveAttemptsException ece) {
                throw new ExcessiveAttemptsException("多次登录锁定账号异常");
            } catch (AuthenticationException ae) { //认证异常
                throw new AuthenticationException("认证异常");
            }
        }
        return "error";
    }

}
