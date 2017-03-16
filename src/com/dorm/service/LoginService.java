package com.dorm.service;

import com.dorm.entity.Role;
import com.dorm.entity.User;

public interface LoginService {
	
    public User findByName(String loginName);   
    
}
