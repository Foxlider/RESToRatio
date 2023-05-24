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
  
		Food p1=new Food("Raclette", "Haute-Savoie", 50, "https://dxm.dam.savencia.com/api/wedia/dam/transform/fix635d9eidk6rrwseqxx1hm46w7gj556bedune/800?t=resize&width=800");
		Food p2=new Food("Magret de Canard", "Occitanie", 80, "https://images.radio-canada.ca/v1/alimentation/recette/4x3/magrets-canard-pommes-terre-salardaise.jpg");
		Food p3=new Food("Paëlla", "Espagne", 40, "https://images.ricardocuisine.com/services/recipes/4x3/7930.jpg");
		Food p4=new Food("Baked beans", "Angleterre", 20, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/BakedBeansAndEggOnToast.jpg/1200px-BakedBeansAndEggOnToast.jpg");
		Food p5=new Food("Roquefort", "Aveyron", 80, "https://www.regal.fr/sites/art-de-vivre/files/styles/teaser/public/roquefort-fromage-bleu_istock.jpg?itok=TnXjtM4e");

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
	public Food getRandomFood(){
		int index=randomGenerator.nextInt(this.foodList.size());
		return this.foodList.get(index);
	}

	public Food addFood(String name, String region, int taste, String imgUrl) {
		Food f=new Food(name, region, taste, imgUrl);
		this.foodList.add(f);
		return f;
	}
	
	

}

