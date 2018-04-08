package com.servicesapi;

import java.util.List;
import com.entities.HalfDay;

public interface HalfDayService {
	public boolean saveOrUpdate(HalfDay halfDay);
	
	public List<HalfDay> list();
	
	public boolean delete(HalfDay halfDay);
}
