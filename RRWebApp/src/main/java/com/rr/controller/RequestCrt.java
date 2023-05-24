package com.rr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // AND NOT @RestController
public class RequestCrt {

	@Value("${welcome.message}")
	private String message;

	private static String messageLocal="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
  
		model.addAttribute("message", message);
		model.addAttribute("messageLocal", messageLocal);

		return "index";
	}
	
	@RequestMapping(value = { "/addFood"}, method = RequestMethod.GET)
    public String addFood(Model model) {
    	FoodFormDTO poneyForm = new PoneyFormDTO();
    	model.addAttribute("foodForm", foodForm);
    	return "foodForm";
    }

	@RequestMapping(value = { "/addFood"}, method = RequestMethod.POST)
    public String addFood(Model model, @ModelAttribute("foodForm") FoodFormDTO foodForm) {
		Food f=foodDao.addFood(foodForm.getName(),foodForm.getRegion(),foodForm.getTaste(),foodForm.getImgUrl());
		model.addAttribute("food",f );
		return "poneyView";
	}
	
	@RequestMapping(value = { "/list"}, method = RequestMethod.GET)
    public String viewList(Model model) {
  	  model.addAttribute("foodList",foodDao.getFoodList() );
  	  return "foodViewList";
    }

}