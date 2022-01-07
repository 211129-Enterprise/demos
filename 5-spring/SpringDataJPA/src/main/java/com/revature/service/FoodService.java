package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.FoodRepository;
import com.revature.model.Food;

@Service
public class FoodService {
<<<<<<< HEAD

	private Logger log = LoggerFactory.getLogger(getClass());
	
	// This class is responsible for calling the data layer and its CRUD methods
	
	@Autowired
	private FoodRepository foodRepo;
	
	public Food findFoodByDishName(String dishName) {
		Optional<Food> possibleFood = foodRepo.findByDishNameIgnoreCase(dishName);
		
		return possibleFood.isPresent() ? possibleFood.get() : null;
	}
	
	// add()
	
	public int add(Food food) {
		// call the repository method to insret a Food object into its respective table
	
=======
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// this class is responsible to calling the data layer and its CRUD methods
	@Autowired
	private FoodRepository foodRepo;
	
	
	// add()
	public int add(Food food) {
		// call the repository method to insert a Food object into its respective table
>>>>>>> main
		Food savedFood = foodRepo.save(food);
		
		int pk = savedFood.getId();
		
<<<<<<< HEAD
		return pk;
=======
		return pk; // return the database
	}
	
	public Food findFoodByDishName(String dishName) {
		
		Optional<Food> possibleFood = foodRepo.findByDishNameIgnoreCase(dishName);
		
		return possibleFood.isPresent() ? possibleFood.get() : null;

	}
	
	// findAllFoods() 
	public List<Food> findAllFoods() {
		
		return foodRepo.findAll(); // this is a method from the JpaRepository
>>>>>>> main
	}
	
	// remove()
	public void deleteById(int id) {
		
		foodRepo.deleteById(id);
<<<<<<< HEAD
		
	}
	// findAllFoods()
	public List<Food> findAllFoods() {
		
		return foodRepo.findAll();
		
	}
=======
	}

>>>>>>> main
}
