package com.rr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rr.model.Food;

@Service
public class FoodDao {
	private List<Food> foodList;
	private Random randomGenerator;
	
	

	public FoodDao() {
		foodList=new ArrayList<>();
		randomGenerator = new Random();
		createFoodList();
	}

	private void createFoodList() {
  
		Food p1=new Food(0, "Raclette", "Haute-Savoie", 50, 10, "https://dxm.dam.savencia.com/api/wedia/dam/transform/fix635d9eidk6rrwseqxx1hm46w7gj556bedune/800?t=resize&width=800");
		Food p2=new Food(1, "Magret de Canard", "Occitanie", 80, 25, "https://images.radio-canada.ca/v1/alimentation/recette/4x3/magrets-canard-pommes-terre-salardaise.jpg");
		Food p3=new Food(2, "Paëlla", "Espagne", 40, 20, "https://images.ricardocuisine.com/services/recipes/4x3/7930.jpg");
		Food p4=new Food(3, "Baked beans", "Angleterre", 20, 5, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/BakedBeansAndEggOnToast.jpg/1200px-BakedBeansAndEggOnToast.jpg");
		Food p5=new Food(4, "Roquefort", "Aveyron", 80, 50, "https://www.regal.fr/sites/art-de-vivre/files/styles/teaser/public/roquefort-fromage-bleu_istock.jpg?itok=TnXjtM4e");

		foodList.add(p1);
		foodList.add(p2);
		foodList.add(p3);
		foodList.add(p4);
		foodList.add(p5);
	}
	
	public List<Food> getFoodList() {
		return this.foodList;
	}
	public Food getFoodByName(String name){
		for (Food food : foodList) {
			if(food.getName().equals(name)){
				return food;
			}
		}
		return null;
	}
	public Food getFoodById(int id){
		for (Food food : foodList) {
			if(food.getId() == id){
				return food;
			}
		}
		return null;
	}
	
	public Food getRandomFood(){
		int index=randomGenerator.nextInt(this.foodList.size());
		return this.foodList.get(index);
	}

	public Food addFood(String name, String region, int taste, int cost, String imgUrl) {
		int i = this.foodList.size();
		Food f=new Food(i, name, region, taste, cost, imgUrl);
		this.foodList.add(f);
		return f;
	}
	public Food addFood(Food f)
	{
		this.foodList.add(f);
		return f;
	}
	
	
	public Food delFood(int id)
	{
		Food f = this.getFoodById(id);
		this.foodList.remove(f);
		return f;
	}
	
	

}

