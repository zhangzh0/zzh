package com.dorm.dao;

import org.springframework.data.repository.Repository;

import com.dorm.entity.User;

public interface LoginDao extends Repository<User, Integer>{
    
	public User findByUserName(String name);
    
	public void delete(Integer id);
			
}
