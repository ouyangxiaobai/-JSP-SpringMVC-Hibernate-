package com.xafdy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xafdy.dao.UserDao;
import com.xafdy.entity.User;

@Service
public class UserService extends BaseService<User> {
	@Resource
	private UserDao userDao;
	
	public User logon(String account, String password) {
		return userDao.logon(account, password);
	}
}
