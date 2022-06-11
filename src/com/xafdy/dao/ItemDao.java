package com.xafdy.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.xafdy.entity.Item;

@Repository
public class ItemDao extends BaseDao<Item> {
	public List<Item> getItemByCity(String city) {
		Query query = getCurrentSession().createQuery("FROM Item WHERE city LIKE :CITY");
		query.setString("CITY", "%" + city + "%");
		
		return query.list();
	}
	
	public List<Item> getItemByName(String name) {
		Query query = getCurrentSession().createQuery("FROM Item WHERE name LIKE :NAME");
		query.setString("NAME", "%" + name + "%");
		
		return query.list();
	}
}
