package com.minihome.comment.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Comment {
	private int commentId;
	private int userId;
	private String username;
    private String nickname;
    private String commentText;
    private String createdAt;
    
    public Comment() {
		// TODO Auto-generated constructor stub
	}
    
    public Comment(int userId, String nickname, String commentText) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.commentText = commentText;
	}

	public Comment(int commentId, int userId, String username, String nickname, String commentText, Timestamp createdAt) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.username = username;
		this.nickname = nickname;
		this.commentText = commentText;
		this.createdAt = new SimpleDateFormat("yyyy.MM.dd").format(createdAt);
	}
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Person [commentId=" + commentId + "userId=" + userId + ", username=" + username +", nickname=" + nickname + ", " + "commentText=" + commentText + "]";
	}
    
    
}