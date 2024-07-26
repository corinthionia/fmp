package com.minihome.comment.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.minihome.comment.dto.Comment;

public interface CommentDAO {
	public int insert(Comment comment)throws SQLException;
	public int update(Comment comment)throws SQLException;
	public int delete(int commentIsd)throws SQLException;
	public Comment select(int commentIsd)throws SQLException; 
	public List<Comment> selectAll()throws SQLException;
}