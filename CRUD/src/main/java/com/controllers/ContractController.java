package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Child;
import com.entities.Contract;
import com.entities.Reservation;
import com.entities.Users;
import com.servicesapi.ChildService;
import com.servicesapi.ContractService;
import com.servicesapi.ReservationService;

@Controller
@RequestMapping("contract")
public class ContractController {
	
	@Autowired
	ContractService contractServices;
	
	@Autowired 
	ReservationService reservationServices;
	
	@Autowired
	ChildService childServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view =new ModelAndView("contract");
		List<Child> childs = childServices.list();
		view.addObject("LIST_CHILD", childs);
		return view;
	}
	
	@RequestMapping(value="/showReservation/{id}", method=RequestMethod.POST)
	public ModelAndView showReservation(@PathVariable("id")int contract_id) {
		ModelAndView view =new ModelAndView("showReservation");
		List<Reservation> reservations = reservationServices.getByContractId(contract_id);
		view.addObject("LIST_RESERVATION", reservations);
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Contract contract){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(contractServices.saveOrUpdate(contract)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Contract contract){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Contract> list = contractServices.list();
			
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
			}else{
				map.put("status","404");
				map.put("message","Data not found");
				
			}
		
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Contract contract){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(contractServices.delete(contract)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
	
}
