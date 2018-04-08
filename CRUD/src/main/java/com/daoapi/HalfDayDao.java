package com.daoapi;

import java.util.List;

import com.entities.HalfDay;

public interface HalfDayDao {
	public boolean saveOrUpdate(HalfDay halfDay);
	
	public List<HalfDay> list();

	public boolean delete(HalfDay haflDay);
}
