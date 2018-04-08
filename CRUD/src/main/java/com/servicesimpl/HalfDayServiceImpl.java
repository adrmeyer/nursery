package com.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.HalfDayDao;
import com.entities.HalfDay;
import com.servicesapi.HalfDayService;

public class HalfDayServiceImpl implements HalfDayService {

	@Autowired
	HalfDayDao halfDayDao;
	
	@Override
	public boolean saveOrUpdate(HalfDay halfDay) {
		// TODO Auto-generated method stub
		return halfDayDao.saveOrUpdate(halfDay);
	}

	@Override
	public List<HalfDay> list() {
		// TODO Auto-generated method stub
		return halfDayDao.list();
	}

	@Override
	public boolean delete(HalfDay halfDay) {
		// TODO Auto-generated method stub
		return halfDayDao.delete(halfDay);
	}

}
