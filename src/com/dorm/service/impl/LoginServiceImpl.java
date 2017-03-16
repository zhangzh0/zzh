package com.dorm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dorm.dao.LoginDao;
import com.dorm.entity.Role;
import com.dorm.entity.User;
import com.dorm.service.LoginService;


@Service("loginSerivce")
public class LoginServiceImpl implements LoginService{
    
	@Resource
	private LoginDao loginDao; 
			
	public User findByName(String loginName) {
		
		User u=loginDao.findByUserName(loginName);
		//System.out.println(u+"uuuuuuuuuuu");		
		return u;
	}
	
}
