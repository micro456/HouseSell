package com.micro.service;

import java.util.List;

import com.micro.entity.User;
import com.micro.utils.Result;


/*
 * 
 */
public interface UserManager {
	
	// 验证用户
	public Result auticationUser(String password, String userName);
	
	// 注册添加用户
	public Result registerUser(User user);
	
	// 获取所有用户
	public List<User> getAllUser();
	
	// 获取所有买家
	public List<User> getAllBuyer();
	
	// 获取所有卖家
	public List<User> getAllSeller();
	
}
