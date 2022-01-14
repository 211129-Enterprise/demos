package com.revature.models;

<<<<<<< HEAD
import java.util.Objects;

public class Person {
	//POJO-Plain Old Java Object
	
	//properties (states)
	//Instance variable - variables specific to every object created by a class
	private String name;
	private int age;//Private is an access modifier 
	private double height;
	private double weight;
	
	//Constructors
	public Person () {
		//This is a no args constructor
	}
	
	//Takes only the name as an argument
	public Person(String name) {
		super();//Calls the object class (or direct parent). Usually you want to use this as the first line of a constructor.
		this.name = name;
	}
	
	//Takes all variables as arguments
=======
// Remmeber that our custom class inherits from the java.lang.Object class
public class Person { // POJO = Plain Old Java Object

	// properties (states)

	// Instance variables - properties specific to each Person object that's
	// instantiated
	private String name;
	private int age;
	private double height;
	private double weight;

	// constructors
	
	public Person() {
		// this is a no-args constructor which allows me to  create a person withour massing in args
	}
	
	public Person(String name) {
		super(); // I'm calling the Object class (or direct parent class)
		this.name = name; // this points to the specific object that I'm instantiating's NAME property 
	}
	
	// a FULLY initialize person
>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

<<<<<<< HEAD
	//Methods (actions)
	public void introduce() {//Use the void return type for methods that perform action and don't pass information back.
		System.out.println("Hi my name is "+name);
	}
	
	//We must use getters and setters to change the private properties of a class. 
	//right click -> source ->generate getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//Overrides the standard printing format from the object class with a more specific form that includes the instance variables of a person object.
	@Override
=======
	// methods (behaviors)
	public void introduce() { // void is a non-access modifier - specifies the return type which is nothing - it just does something 
		System.out.println("Hello my name is " + name); 
		// by default, we know that name refers to the instance variable of this object that's calling it
	}
	

	// we must generate getters & setters so that we can change the private
	// properties of the objects that are created from this class
	
	// right click -> source -> generate getters & setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	// we can override a method that we inherit from the Object class
	@Override // overrideing the toString() method from the IObject class to rpoerly reflect the specific instanct varibale of a Perosn object
>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
<<<<<<< HEAD
		return Objects.hash(age, height, name, weight);
=======
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
<<<<<<< HEAD
		return age == other.age && Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	
	
	
=======
		if (age != other.age)
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	
	

>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
}
