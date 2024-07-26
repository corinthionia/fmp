package com.minihome.user.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minihome.user.dto.User;
import com.minihome.user.model.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;
	
	@Override
	public int add(User user) throws SQLException {
		return dao.insert(user);
	}

	@Override
	public int edit(User user) throws SQLException {
		return dao.update(user);
	}

	@Override
	public int remove(int id) throws SQLException {
		return dao.delete(id);
	}

	@Override
	public User read(int id) throws SQLException {
		return dao.select(id);
	}

	@Override
	public List<User> readAll() throws SQLException {
		return dao.selectAll();
	}
	
	@Override
    public User findByName(String name) throws SQLException {
        return dao.selectByName(name);
    }

}
