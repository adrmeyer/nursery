package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ReservationDao;
import com.entities.Reservation;

@Repository("ReservationDao")
@Transactional
public class ReservationImpl implements ReservationDao {
	
	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Reservation reservation) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(reservation);
		
		return true;
	}
	
	public List<Reservation> list() {
		return session.getCurrentSession().createQuery("from Reservation").list();
	}
	
	public boolean delete(Reservation reservation) {
		try {
			session.getCurrentSession().delete(reservation);
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}
}
