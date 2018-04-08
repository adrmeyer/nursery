package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.daoapi.ContractDao;
import com.entities.Contract;

public class ContractServiceImpl {

    @Autowired
    ContractDao contractDao;
 
    public boolean saveOrUpdate(Contract contract) {
        return contractDao.saveOrUpdate(contract);
    }
 
    public List<Contract> list() {
        // TODO Auto-generated method stub
        return contractDao.list();
    }
 
    public boolean delete(Contract contract) {
        // TODO Auto-generated method stub
        return contractDao.delete(contract);
    }
}
