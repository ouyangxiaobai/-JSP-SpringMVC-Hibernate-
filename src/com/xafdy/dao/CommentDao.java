package com.xafdy.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.xafdy.entity.Comment;

@Repository
public class CommentDao extends BaseDao<Comment> {
	public List<Comment> getCommentByItem(Integer itemId) {
		Query query = getCurrentSession().createQuery("FROM Comment WHERE item.id = ?");
		query.setParameter(0, itemId);
		
		return query.list();
	}
}
