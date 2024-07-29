package com.minihome.guestbook.model.service;

import java.sql.SQLException;
import java.util.List;

import com.minihome.guestbook.dto.Guestbook;

public interface GuestbookService {	
	public int add(Guestbook guestbook)throws SQLException;
	public int edit(Guestbook guestbook)throws SQLException;
	public int remove(int guestbookId)throws SQLException;
	public Guestbook read(int guestbookId)throws SQLException;
	public List<Guestbook> readAll()throws SQLException;
}
