package com.xafdy.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.xafdy.entity.Foods;

@Repository
public class FoodsDao extends BaseDao<Foods> {
	public List<Foods> getFoodsByItemId(Integer itemId) {
		Query query = getCurrentSession().createQuery("FROM Foods WHERE item.id = ?");
		query.setParameter(0, itemId);
		
		return query.list();
	}
}
