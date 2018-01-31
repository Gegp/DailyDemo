package com.ggp.service.login.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ggp.dao.Dao;
import com.ggp.entity.User;
import com.ggp.service.login.LoginService;
@Service("loginService")

public class LoginServiceImpl implements LoginService{
	
	
	@Resource(name="dao")
	private Dao dao;
	
	
	@Override
	public User getUser(User u) throws Exception {
		return (User) dao.findForObject("LoginMapper.getUser",u);
	}
	@Override
	public User getName(User u) throws Exception {
		return (User) dao.findForObject("LoginMapper.getUser",u);
	}

}
