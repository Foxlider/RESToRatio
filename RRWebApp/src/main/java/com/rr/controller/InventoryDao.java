package com.rr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.rr.model.Food;

@Service
public class InventoryDao {
	
	private List<Food> inventory;
	
	
	public InventoryDao() {
		inventory=new ArrayList<>();
	}
	
	public List<Food> getInventory() {
		return this.inventory;
	}
	
	public Food getFoodByName(String name){
		for (Food food : inventory) {
			if(food.getName().equals(name)){
				return food;
			}
		}
		return null;
	}
	
	public Food getFoodById(int id){
		for (Food food : inventory) {
			if(food.getId() == id){
				return food;
			}
		}
		return null;
	}

	public Food addFood(Food food) {
		this.inventory.add(food);
		return food;
	}
	public Food delFood(int id) {
		
		Food f = this.getFoodById(id);
		this.inventory.remove(f);
		return f;
	}
}
