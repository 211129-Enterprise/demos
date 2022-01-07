package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Food;

<<<<<<< HEAD
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
=======
/**
 * Spring Data is a part of the Spring Framework. The goal of Spring Data
 * repository abstraction is to significantly reduce the amount of boilerplate
 * code required to implement data access layers for various persistence stores.
 * 
 * Spring Data JPA is not a JPA provider. It is a library/framework that adds an
 * extra layer of abstraction on the top of our JPA provider (like Hibernate).
 * THERE ARE OTHER JPA PROVIDERS (or JPA implementation frameworks a.k.a ORM's )
 */

// Spring Security - JWT tokens to manage User authentication and authorization in conjunction with a Service in our Frontend App (Angular)


@Repository // this is marking this class as a DAO component
public interface FoodRepository extends JpaRepository<Food, Integer>{ // <Object, Primary Key Data Type>

	// Spring Data automatically generates the DAO Impl class of this interface and all crud methods
	// .save(), .delete(), .update()
	
	/**
	 *  Property Expressions in Spring (look in Spring documentation about this)
	 *  
	 *  Spring Data JPA will examine all the properties of the class that corresponds
	 *  to this repository and INFER SQL STATEMENTS based on the direct properties of the class.
	 * 
	 */
	
//	Food findByDishName(String dishName); // SELECT * FROM food WHERE dish_name = ?
>>>>>>> main
	
	public List<Food> findByOrderByDishName();
	
	public Optional<Food> findByDishNameIgnoreCase(String dishName);
	
<<<<<<< HEAD
	// custom query
	@Query(value="FROM Food WHERE dishName like %:substring")
	public Food findByDishNameContains(String substring);
=======
	// custom queries!
	@Query(value="FROM Food WHERE dishName like %:substring")
	public Food findByDishNameContains(String substring);
	
	
	
>>>>>>> main
}
