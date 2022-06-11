package com.xafdy.dao;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.xafdy.entity.Admin;

@Repository
public class AdminDao extends BaseDao<Admin> {
	public Admin logon(String account, String password) {
		Query query = getCurrentSession().createQuery("FROM Admin WHERE account = ? AND password = ?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		
		return (Admin)query.uniqueResult();
	}
}
