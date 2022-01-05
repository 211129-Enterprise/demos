package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Food;

@Repository // This is marking this class as a DAO component specific to FOOD objects
public interface FoodRepository extends JpaRepository<Food, Integer>{ //<Object, Primary Key Data Type>

	// Spring data automatically generates the DAO Impl class of this interface
	// and all CRUD methods
	// For example: .save(), .delete(), .update(), etc
	
	
	/*
	 *  Property Expression in Spring (Look in Spring documentations about this)
	 *  
	 *  Spring Data JPA will examine all the properties of the class that corresponds
	 *  to this repository and INFER SQL STATEMENTS based on the direct properties of
	 *  the class.
	 */
	Food findByDishName(String dishName); // SELECT * FROM food WHERE dishName = ?
	
	public List<Food> findByOrderByDishName();
	
	public Optional<Food> findByDishNameIgnoreCase(String dishName);
	
	// custom queries!
	@Query(value="FROM Food WHERE dishName like %:substring")
	public Food findByDishNameContains(String substring);
	
}
