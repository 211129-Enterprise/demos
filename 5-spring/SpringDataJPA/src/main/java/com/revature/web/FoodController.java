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

@RestController // All methods in the class will return an HTTP response
@RequestMapping("/food") // all methods are available at http://localhost:8080/food
public class FoodController {

	// making calls to the FoodService
	@Autowired
	private FoodService foodServ;

	// POST request to http://localhost:8080/food/add
	@PostMapping("/add")
	public int addFood(@RequestBody Food food) { // This food request comes from the request body of the HTTP request
		// returns the PK of the added food
		return foodServ.add(food);
		
	}
	
	@GetMapping("/all") // returns all food in the database
	public List<Food> findAllFoods() {
		
		return foodServ.findAllFoods();
		
	}

}
