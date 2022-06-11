package com.xafdy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xafdy.dao.CommentDao;
import com.xafdy.entity.Comment;

@Service
public class CommentService extends BaseService<Comment> {
	@Resource
	private CommentDao commentDao;
	
	public List<Comment> getCommentByItem(Integer itemId) {
		return commentDao.getCommentByItem(itemId);
	}
}
