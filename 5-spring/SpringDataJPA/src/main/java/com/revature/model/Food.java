package com.revature.model;

<<<<<<< HEAD
import java.util.Objects;

=======
>>>>>>> main
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
<<<<<<< HEAD
	private String dishName;
=======
	private String dishName; // this automatically turns into dish_name 
>>>>>>> main
	
	private int calories;

	public Food() {
<<<<<<< HEAD
		// must create no-args constructor
	}
	public Food(String dishName, int calories) {
		super();
		this.dishName = dishName;
		this.calories = calories;
	}
	
=======
		// must create constructor for Food
	}

>>>>>>> main
	public Food(int id, String dishName, int calories) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.calories = calories;
	}

<<<<<<< HEAD
=======
	public Food(String dishName, int calories) {
		super();
		this.dishName = dishName;
		this.calories = calories;
	}
	
	
>>>>>>> main
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

	@Override
	public int hashCode() {
<<<<<<< HEAD
		return Objects.hash(calories, dishName, id);
=======
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + ((dishName == null) ? 0 : dishName.hashCode());
		result = prime * result + id;
		return result;
>>>>>>> main
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
<<<<<<< HEAD
		return calories == other.calories && Objects.equals(dishName, other.dishName) && id == other.id;
=======
		if (calories != other.calories)
			return false;
		if (dishName == null) {
			if (other.dishName != null)
				return false;
		} else if (!dishName.equals(other.dishName))
			return false;
		if (id != other.id)
			return false;
		return true;
>>>>>>> main
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", dishName=" + dishName + ", calories=" + calories + "]";
	}
<<<<<<< HEAD
	
	
	
=======
>>>>>>> main
}
