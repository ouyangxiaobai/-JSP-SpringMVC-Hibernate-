package com.xafdy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xafdy.dao.FoodsDao;
import com.xafdy.entity.Foods;

@Service
public class FoodsService extends BaseService<Foods> {
	@Resource
	private FoodsDao foodsDao;
	public List<Foods> getFoodsByItemId(Integer itemId) {
		return foodsDao.getFoodsByItemId(itemId);
	}
}
