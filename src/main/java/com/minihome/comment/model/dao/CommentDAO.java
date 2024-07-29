package com.minihome.comment.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.minihome.comment.dto.Comment;

public interface CommentDAO {
	public int insert(Comment comment)throws SQLException;
	public int update(Comment comment)throws SQLException;
	public int delete(int commentId)throws SQLException;
	public Comment select(int commentId)throws SQLException; 
	public List<Comment> selectAll()throws SQLException;
	public Integer selectCommentAuthor(int commentId) throws SQLException;
}