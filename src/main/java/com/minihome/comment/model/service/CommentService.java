package com.minihome.comment.model.service;

import java.sql.SQLException;
import java.util.List;

import com.minihome.comment.dto.Comment;

public interface CommentService {	
	public int add(Comment comment)throws SQLException;
	public int edit(Comment comment)throws SQLException;
	public int remove(int commentId)throws SQLException;
	public Comment read(int commentId)throws SQLException;
	public List<Comment> readAll()throws SQLException;
	public int findCommentAuthor(int commentId) throws SQLException;
}
