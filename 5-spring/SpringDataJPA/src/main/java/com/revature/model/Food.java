package com.revature.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String dishName;
	
	private int calories;
	
	public Food() {
		// Must create constructor for food
	}
	
	
	
// C O N S T R U C T O R S	
	public Food(String dishName, int calories) {
		super();
		this.dishName = dishName;
		this.calories = calories;
	}

	public Food(int id, String dishName, int calories) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.calories = calories;
	}

	
	
// G E T T E R S   &   S E T T E R S	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	
	
// O V E R R I D E S
	@Override
	public int hashCode() {
		return Objects.hash(calories, dishName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return calories == other.calories && Objects.equals(dishName, other.dishName) && id == other.id;
	}
	
	

}
