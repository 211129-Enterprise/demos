package com.revature.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Food;
import com.revature.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	private FoodService foodService;
	
	@PostMapping("/add")
	public int addFood(@RequestBody Food food) {
		
		return foodService.add(food);
	}
	
	@GetMapping("/all")
	public List<Food> findAllFoods() {
		
		return foodService.findAllFoods();
	}
	
	
}
