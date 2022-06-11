package com.xafdy.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.xafdy.entity.User;

@Repository
public class UserDao extends BaseDao<User> {
	public User logon(String account, String password) {
		Query query = getCurrentSession().createQuery("FROM User WHERE account = ? AND password = ?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		
		return (User) query.uniqueResult();
	}
}
