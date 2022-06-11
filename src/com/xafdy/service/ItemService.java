package com.xafdy.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.xafdy.dao.ItemDao;
import com.xafdy.entity.Item;

@Service
public class ItemService extends BaseService<Item> {
	@Resource
	private ItemDao itemDao;
	
	public List<Item> getItemByCity(String city) {
		return itemDao.getItemByCity(city);
	}
	
	public List<Item> getItemByName(String name) {
		return itemDao.getItemByName(name);
	}
}
