package com.minihome.user.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.minihome.user.dto.User;

public interface UserDAO {
	public int insert(User user)throws SQLException;
	public int update(User user)throws SQLException;
	public int delete(int id)throws SQLException;
	public User select(int id)throws SQLException; 
	public List<User> selectAll()throws SQLException;
	User selectByName(String name) throws SQLException;
}