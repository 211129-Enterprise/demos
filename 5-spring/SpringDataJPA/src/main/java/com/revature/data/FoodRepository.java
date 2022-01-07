package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Food;

@Repository // this is marking this clas as a DAO component
public interface FoodRepository extends JpaRepository<Food, Integer> { // <Object, Primary Key Data Type>
	
	// SpringData automatically generates the DAO Impl class of this interface and all crud methods
	// .save(), .delete(), .update()
	
	/**
	 * Property Expressions in Spring (look in Spring documentation about this)
	 * 
	 * Spring Data JPA will examine all the properties of the class that corresponds
	 * to this repository and INFER SQL Statements based on the direct properties of the class.
	 * 
	 */
	
//	Food findByDishName(String dishName);
	
	public List<Food> findByOrderByDishName();
	
	public Optional<Food> findByDishNameIgnoreCase(String dishName);
	
	// custom query
	@Query(value="FROM Food WHERE dishName like %:substring")
	public Food findByDishNameContains(String substring);
}
