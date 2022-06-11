package com.xafdy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xafdy.dao.BaseDao;

@Service
public class BaseService<T> {
	
	@Resource
	private BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public Integer saveEntity(T t) {
		return baseDao.saveEntity(t);
	}
	
	public void saveEntities(List<T> ts) {
		baseDao.saveEntities(ts);
	}
	
	public void mergeEntity(T t) {
		baseDao.mergeEntity(t);
	}
	
	public void updateEntity(T t) {
		baseDao.updateEntity(t);
	}
	
	public void deleteEntity(T t) {
		baseDao.deleteEntity(t);
	}
	
	public List<T> getEntities(Class<T> clazz) {
		return baseDao.getEntities(clazz);
	}
	
	public T getEntityById(Class<T> clazz, Integer id) {
		return baseDao.getEntityById(clazz, id);
	}
	
	public List<T> getEntitiesByUserId(Class<T> clazz, Integer userId) {
		return baseDao.getEntitiesByUserId(clazz, userId);
	}
}
