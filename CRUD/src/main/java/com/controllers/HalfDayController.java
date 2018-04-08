package com.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.HalfDay;
import com.servicesapi.HalfDayService;

@Controller
@RequestMapping("halfDay")
public class HalfDayController {
	
	@Autowired
	HalfDayService halfDayServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("halfDay");
		return view;
	}
	

	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(HalfDay halfDay){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(halfDayServices.saveOrUpdate(halfDay)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	
}
