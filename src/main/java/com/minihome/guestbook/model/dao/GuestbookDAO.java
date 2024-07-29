package com.minihome.guestbook.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.minihome.guestbook.dto.Guestbook;

public interface GuestbookDAO {
	public int insert(Guestbook guestbook)throws SQLException;
	public int update(Guestbook guestbook)throws SQLException;
	public int delete(int guestbookId)throws SQLException;
	public Guestbook select(int guestbookIsd)throws SQLException; 
	public List<Guestbook> selectAll()throws SQLException;
}