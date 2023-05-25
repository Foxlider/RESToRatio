package com.rr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rr.model.*;

@Controller // AND NOT @RestController
public class RequestCrt {

	@Autowired
	FoodDao foodDao;
	
	@Autowired
	InventoryDao inventoryDao;
	
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
    	FoodFormDTO foodForm = new FoodFormDTO();
    	model.addAttribute("foodForm", foodForm);
    	return "foodForm";
    }

	@RequestMapping(value = { "/addFood"}, method = RequestMethod.POST)
    public String addFood(Model model, @ModelAttribute("foodForm") FoodFormDTO foodForm) {
		Food f=foodDao.addFood(foodForm.getName(),foodForm.getRegion(),foodForm.getTaste(),foodForm.getCost(),foodForm.getImgUrl());
		model.addAttribute("food",f );
		return "foodView";
	}
	
	@RequestMapping(value = { "/shop"}, method = RequestMethod.GET)
    public String viewShop(Model model) {
  	  model.addAttribute("foodList",foodDao.getFoodList() );
  	  return "foodViewList";
    }
	
	@RequestMapping(value = { "/inventory"}, method = RequestMethod.GET)
    public String viewInventory(Model model) {
		model.addAttribute("inventory",inventoryDao.getInventory() );
  	  return "foodViewList";
    }
	
	@RequestMapping(value = { "/view"}, method = RequestMethod.GET)
    public String view(Model model) {
	    model.addAttribute("food",foodDao.getRandomFood() );
	    return "foodView";
	}
	
	@RequestMapping(value = { "/buyFood"}, method = RequestMethod.GET)
    public String buyFood(@RequestParam("id") int id, Model model) {
		Food f = foodDao.delFood(id);
		Food f2 = inventoryDao.addFood(f);
		model.addAttribute("inventory",inventoryDao.getInventory() );
	    return "inventoryViewList";
	}
	
	@RequestMapping(value = { "/sellFood"}, method = RequestMethod.GET)
    public String sellFood(@RequestParam("id") int id, Model model) {
		Food f = inventoryDao.delFood(id);
		Food f2 = foodDao.addFood(f);
		model.addAttribute("inventory",inventoryDao.getInventory() );
	    return "inventoryViewList";
	}

}