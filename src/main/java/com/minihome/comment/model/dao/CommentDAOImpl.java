package com.minihome.comment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minihome.comment.dto.Comment;
import com.minihome.util.DBUtil;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	DBUtil dbUtil;
	
	@Override
	public int insert(Comment comment) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql = "insert into comments (userId,nickname,commentText) values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, comment.getUserId());
		pstmt.setString(2, comment.getNickname());
		pstmt.setString(3, comment.getCommentText());
		
		return pstmt.executeUpdate();
	}

	@Override
	public int update(Comment comment) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="update comments set commentText=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, comment.getCommentText());
		pstmt.setInt(2, comment.getCommentId());
		
		return pstmt.executeUpdate();
	}

	@Override
	public int delete(int commentId) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="delete from comments where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, commentId);
		
		return pstmt.executeUpdate();
	}

	@Override
	public Comment select(int commentId) throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql="SELECT u.id AS userId, c.id as commentId, u.name AS username, c.nickname, c.commentText, c.createdAt " +
          	  		"FROM comments c " +
          	  		"JOIN users u ON c.userId = u.id" +
					"WHERE commentId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, commentId);
		   
		ResultSet rs = pstmt.executeQuery();
		Comment comment = null;
		
		if (rs.next()) {
			comment = new Comment(
				rs.getInt("id"),
				rs.getInt("userId"),
				rs.getString("username"),
				rs.getString("nickname"),
				rs.getString("commentText"),
				rs.getTimestamp("createdAt")
			);
		}
		
		return comment;
	}

	@Override
	public List<Comment> selectAll() throws SQLException {
		Connection conn = dbUtil.getConnection();
		
		String sql = "SELECT u.id AS userId, c.id as commentId, u.name AS username, c.nickname, c.commentText, c.createdAt " +
                	  "FROM comments c " +
                	  "JOIN users u ON c.userId = u.id";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		List<Comment> list= new ArrayList<>();
		
		while (rs.next()) {
			list.add(new Comment(
					rs.getInt("commentId"),
					rs.getInt("userId"),
					rs.getString("username"),
					rs.getString("nickname"),
					rs.getString("commentText"),
					rs.getTimestamp("createdAt")
			));
		}
		
		return list;
	}

}



