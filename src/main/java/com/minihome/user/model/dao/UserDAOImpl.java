package com.minihome.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minihome.user.dto.User;
import com.minihome.util.DBUtil;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	DBUtil dbUtil;
	
	@Override
	public int insert(User user) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql = "insert into users (name,password) values (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPassword());
		
		return pstmt.executeUpdate();
	}

	@Override
	public int update(User user) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="update users set password=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getPassword());
		pstmt.setInt(2, user.getId());
		
		return pstmt.executeUpdate();
	}

	@Override
	public int delete(int id) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="delete from users where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		
		return pstmt.executeUpdate();
	}

	@Override
	public User select(int id) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="select id,name,password from users where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		   
		ResultSet rs = pstmt.executeQuery();
		User user = null;
		
		if (rs.next()) {
			user = new User(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("password")
			);
		}
		
		return user;
	}

	@Override
	public List<User> selectAll() throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql = "select id,name,password from users";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		List<User> list= new ArrayList<>();
		
		while (rs.next()) {
			list.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password")));
		}
		
		return list;
	}
	
	@Override
    public User selectByName(String name) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
        String sql = "select * from users where name = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, name);
        
        ResultSet rs = pstmt.executeQuery();
		User user = null;
		
		if (rs.next()) {
			user = new User(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("password")
			);
		}
		
		return user;
    }

}



