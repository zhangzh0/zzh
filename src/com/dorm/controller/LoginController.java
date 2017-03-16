package com.dorm.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dorm.entity.Role;
import com.dorm.entity.User;
import com.dorm.service.LoginService;
import com.google.code.kaptcha.Constants;

@Controller("loginController")
@RequestMapping("/dorm")
public class LoginController {
    
	private String LOGIN_SUCCESS="login/login_success";
	private String LOGIN_FAIL="login/login_fail";
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login.do")
	public String login(User user,HttpServletRequest request) throws Exception{
		String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		User u=loginService.findByName(user.getUserName());
		if(u!=null){
			
			UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),user.getUserPassword());
			Subject subject=SecurityUtils.getSubject();
			subject.login(token);
			
			return LOGIN_SUCCESS;
		}
		return LOGIN_FAIL;
	}
}
