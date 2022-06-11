package com.xafdy.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao <T> {
	
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Integer saveEntity(T t) {
		return (Integer)getCurrentSession().save(t);
	}
	
	public void saveEntities(List<T> ts) {
		for (T t : ts) {
			getCurrentSession().save(t);
		}
	}
	
	public void mergeEntity(T t) {
		getCurrentSession().merge(t);
	}
	
	public void updateEntity(T t) {
		getCurrentSession().update(t);
	}
	
	public void deleteEntity(T t) {
		getCurrentSession().delete(t);
	}
	
	public List<T> getEntities(Class<T> clazz) {
		Query query = getCurrentSession().createQuery("FROM " + clazz.getSimpleName());
		return (List<T>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public T getEntityById(Class<T> clazz, Integer id) {
		String hql = "FROM " + clazz.getSimpleName() + " WHERE id = ?";
		Query query = getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (T) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getEntitiesByUserId(Class<T> clazz, Integer userId) {
		String hql = "FROM " + clazz.getSimpleName() + " WHERE user.id = ?";
		Query query = getCurrentSession().createQuery(hql);
		query.setInteger(0, userId);
		
		return (List<T>) query.list();
	}
}
