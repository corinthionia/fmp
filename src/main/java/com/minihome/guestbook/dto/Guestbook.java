package com.minihome.guestbook.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Guestbook {
	private int guestbookId;
	private int userId;
	private String username;
    private String guestbookText;
    private String createdAt;
    
    public Guestbook() {
		// TODO Auto-generated constructor stub
	}
    
    public Guestbook(int userId, String guestbookText) {
		super();
		this.userId = userId;
		this.guestbookText = guestbookText;
	}

	public Guestbook(int guestbookId, int userId, String username, String guestbookText, Timestamp createdAt) {
		super();
		this.guestbookId = guestbookId;
		this.userId = userId;
		this.username = username;
		this.guestbookText = guestbookText;
		this.createdAt = new SimpleDateFormat("yyyy.MM.dd").format(createdAt);
	}
	
	public int getGuestbookId() {
		return guestbookId;
	}

	public void setGuestbookId(int guestbookId) {
		this.guestbookId = guestbookId;
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

	public String getGuestbookText() {
		return guestbookText;
	}

	public void setGuestbookText(String guestbookText) {
		this.guestbookText = guestbookText;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Person [guestbookId=" + guestbookId + "userId=" + userId + ", username=" + username + "guestbookText=" + guestbookText + "]";
	}
    
    
}