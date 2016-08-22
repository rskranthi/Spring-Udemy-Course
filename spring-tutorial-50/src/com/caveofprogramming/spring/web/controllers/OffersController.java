package com.caveofprogramming.spring.web.controllers;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
	
	/*
	
	@RequestMapping("/")
	public ModelAndView showHome()
	{
		
		ModelAndView model = new ModelAndView("home");
		
		Map<String,Object> mod = model.getModel();
		
		mod.put("name","River");
		return model;
	}
*/
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}


	@RequestMapping("/offers")
	public String showOffers(Model model)
	{
		//offersService.throwTestException();
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers",offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model)
	{
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate",method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Offer offer,BindingResult result)
	{
		
		if(result.hasErrors())
		{
			return "createoffer";
		}
		
		offersService.create(offer);
		
		return "offercreated";
	}
	/*
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){
		return "error";
	}
	*/
}
