package com.daoapi;

import java.util.List;

import com.entities.Reservation;

public interface ReservationDao {
	public boolean saveOrUpdate(Reservation reservation);
	
	public List<Reservation> list();
	
	public boolean delete(Reservation reservation);
}
