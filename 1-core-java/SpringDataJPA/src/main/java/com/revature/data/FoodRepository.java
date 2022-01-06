package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{
	Food findByDishName(String dishName);
	
	public List<Food> findByOrderByDishName();
	
	public Optional<Food> findByDishNameIgnoreCase(String dishName);
}
