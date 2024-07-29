package com.minihome.guestbook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minihome.guestbook.dto.Guestbook;
import com.minihome.util.DBUtil;

@Repository
public class GuestbookDAOImpl implements GuestbookDAO {

	@Autowired
	DBUtil dbUtil;
	
	@Override
	public int insert(Guestbook guestbook) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql = "insert into guestbooks (userId,guestbookText) values (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, guestbook.getUserId());
		pstmt.setString(2, guestbook.getGuestbookText());
		
		return pstmt.executeUpdate();
	}

	@Override
	public int update(Guestbook guestbook) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="update guestbooks set guestbookText=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, guestbook.getGuestbookText());
		pstmt.setInt(2, guestbook.getGuestbookId());
		
		return pstmt.executeUpdate();
	}

	@Override
	public int delete(int guestbookId) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="delete from guestbooks where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, guestbookId);
		
		return pstmt.executeUpdate();
	}

	@Override
	public Guestbook select(int guestbookId) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="SELECT u.id AS userId, g.id as guestbookId, u.name AS username, g.guestbookText, g.createdAt " +
          	  		"FROM guestbooks g " +
          	  		"JOIN users u ON g.userId = u.id" +
					"WHERE guestbookId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, guestbookId);
		   
		ResultSet rs = pstmt.executeQuery();
		Guestbook guestbook = null;
		
		if (rs.next()) {
			guestbook = new Guestbook(
				rs.getInt("id"),
				rs.getInt("userId"),
				rs.getString("username"),
				rs.getString("guestbookText"),
				rs.getTimestamp("createdAt")
			);
		}
		
		return guestbook;
	}

	@Override
	public List<Guestbook> selectAll() throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql = "SELECT u.id AS userId, g.id AS guestbookId, u.name AS username, g.guestbookText, g.createdAt " +
	             "FROM guestbooks g " +
	             "JOIN users u ON g.userId = u.id " +
	             "ORDER BY g.createdAt DESC";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		List<Guestbook> list= new ArrayList<>();
		
		System.out.println(list);
		
		while (rs.next()) {
			list.add(new Guestbook(
					rs.getInt("guestbookId"),
					rs.getInt("userId"),
					rs.getString("username"),
					rs.getString("guestbookText"),
					rs.getTimestamp("createdAt")
			));
		}
		
		return list;
	}

}



