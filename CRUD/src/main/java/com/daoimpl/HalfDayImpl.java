package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import com.daoapi.HalfDayDao;
import com.entities.HalfDay;

@Repository("HalfDayDao")
@Transactional
public class HalfDayImpl implements HalfDayDao {
	
	@Autowired
	SessionFactory session;

	@Override
	public boolean saveOrUpdate(HalfDay halfDay) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(halfDay);
		return true;
	}

	@Override
	public List<HalfDay> list() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from HalfDay").list();
	}

	@Override
	public boolean delete(HalfDay halfDay) {
		try {
            session.getCurrentSession().delete(halfDay);
        } catch (Exception ex) {
            return false;
        }
 
        return true;	}

}
