package com.xafdy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xafdy.dao.AdminDao;
import com.xafdy.entity.Admin;

@Service
public class AdminService extends BaseService<Admin> {
	@Resource
	private AdminDao adminDao;
	
	public Admin logon(String account, String password) {
		return adminDao.logon(account, password);
	}
}
