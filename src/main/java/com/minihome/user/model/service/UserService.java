package com.minihome.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.minihome.user.dto.User;

public interface UserService {	
	public int add(User user)throws SQLException;
	public int edit(User user)throws SQLException;
	public int remove(int id)throws SQLException;
	public User read(int id)throws SQLException;
	public List<User> readAll()throws SQLException;
	User findByName(String name) throws SQLException;
}
