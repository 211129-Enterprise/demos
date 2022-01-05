package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Food;
import com.revature.service.FoodService;

@RestController // All methods in the class will return some type of HTTP response
@RequestMapping("/food") // All methods are available at http://localhost:8080/food
public class FoodController {
	
	
	// Make calls to the FoodService
	@Autowired
	private FoodService foodService;
	
	
	// POST request to http://localhost:8080/food/add
	@PostMapping("/add")
	public int addFood(@RequestBody Food food) { // This obj comes from the request body of the HTTP request
		
		// Returns the primary key of the added Food
		return foodService.add(food);
		
	}

	@GetMapping("/all") // Returns all food in the database http://localhost:8080/food/all
	public List<Food> findAllFoods(){
		
		return foodService.findAllFoods();
		
	}
}
