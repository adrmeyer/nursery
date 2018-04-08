package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.daoapi.ReservationDao;
import com.entities.Reservation;
import com.servicesapi.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	public boolean saveOrUpdate(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.saveOrUpdate(reservation);
	}

	public List<Reservation> list() {
		// TODO Auto-generated method stub
		return reservationDao.list();
	}

	public boolean delete(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.delete(reservation);
	}

}
