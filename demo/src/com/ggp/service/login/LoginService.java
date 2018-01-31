package com.ggp.service.login;

import org.springframework.stereotype.Service;

import com.ggp.entity.User;


public interface LoginService {
	
	/*
	  登录验证
	 */
	public User getUser(User u) throws Exception;
	/*
	  名称查询
	 */
	public User getName(User u) throws Exception;
}
