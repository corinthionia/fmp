package com.minihome.guestbook.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minihome.guestbook.dto.Guestbook;
import com.minihome.guestbook.model.dao.GuestbookDAO;

@Service
public class GuestbookServiceImp implements GuestbookService {

	@Autowired
	GuestbookDAO dao;
	
	@Override
	public int add(Guestbook guestbook) throws SQLException {
		return dao.insert(guestbook);
	}

	@Override
	public int edit(Guestbook guestbook) throws SQLException {
		return dao.update(guestbook);
	}

	@Override
	public int remove(int guestbookId) throws SQLException {
		return dao.delete(guestbookId);
	}

	@Override
	public Guestbook read(int guestbookId) throws SQLException {
		return dao.select(guestbookId);
	}

	@Override
	public List<Guestbook> readAll() throws SQLException {
		return dao.selectAll();
	}
}
