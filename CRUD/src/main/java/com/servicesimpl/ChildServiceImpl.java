package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.daoapi.ChildDao;
import com.entities.Child;
import com.servicesapi.ChildService;

public class ChildServiceImpl implements ChildService {
	
	@Autowired
	ChildDao childDao;


	@Override
	public boolean saveOrUpdate(Child child) {
		// TODO Auto-generated method stub
		return childDao.saveOrUpdate(child);
	}

	@Override
	public List<Child> list() {
		// TODO Auto-generated method stub
		return childDao.list();
	}

	@Override
	public boolean delete(Child child) {
		// TODO Auto-generated method stub
		return childDao.delete(child);
	}

}
