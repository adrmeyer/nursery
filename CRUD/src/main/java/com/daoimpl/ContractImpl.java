package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ContractDao;
import com.entities.Contract;

@Repository("ContractDao")
@Transactional
public class ContractImpl implements ContractDao {

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Contract contract) {
        // TODO Auto-generated method stub
        session.getCurrentSession().saveOrUpdate(contract);

        return true;
    }
 
    public List<Contract> list() {
        return session.getCurrentSession().createQuery("from Contract").list();
    }
 
    public boolean delete(Contract contract) {
        try {
            session.getCurrentSession().delete(contract);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }
}