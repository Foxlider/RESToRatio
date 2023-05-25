package com.rr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rr.model.Food;

@RestController
public class RrRestCrt {
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	InventoryDao inventoryDao;
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="/api/food")
    public List<Food> getFoodList() {
        List<Food> f=foodDao.getFoodList();
        return f;
    }
	
	@RequestMapping(method=RequestMethod.GET,value="/api/food/{id}")
    public Food getFood(@PathVariable String id) {
        Food f=foodDao.getFoodById(Integer.valueOf(id));
        return f;
    }
		
	@RequestMapping(method=RequestMethod.GET,value="/api/inventory")
    public List<Food> getInventoryList() {
        List<Food> f=inventoryDao.getInventory();
        return f;
    }
}
