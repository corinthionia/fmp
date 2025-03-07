package com.minihome.comment.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minihome.comment.dto.Comment;
import com.minihome.comment.model.dao.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO dao;
	
	@Override
	public int add(Comment comment) throws SQLException {
		return dao.insert(comment);
	}

	@Override
	public int edit(Comment comment) throws SQLException {
		return dao.update(comment);
	}

	@Override
	public int remove(int commentId) throws SQLException {
		return dao.delete(commentId);
	}

	@Override
	public Comment read(int commentId) throws SQLException {
		return dao.select(commentId);
	}

	@Override
	public List<Comment> readAll() throws SQLException {
		return dao.selectAll();
	}
	
	 public int findCommentAuthor(int commentId) throws SQLException {
	        return dao.selectCommentAuthor(commentId);
	    }
}
