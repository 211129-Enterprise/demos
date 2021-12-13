package com.revature.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.lambdas.Employee;

/* Consumer, Predicate, and Supplier are all functional interfaces */
public class Driver {

	
	public static void main(String[] args) {
	
		
	/* CONSUMER INTERFACE */
		// .forEach(takes in a Consumer object) -> provide implementation for accept() method
		
		
		// Instantiate a few employees here
		Employee zayn = new Employee("Zayn Smith", 42);
		Employee abby = new Employee("Abby McCormick", 36);
		Employee edward = new Employee("Edward Zyrtec", 56);
		Employee xavier = new Employee("Xavier Hallsworth", 19);
		
		
		
		// Create some array list of employees and add them to it
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		employees.add(new Employee("Someone Smith", 22));

		
		
		// Passing in class that explicitly provides the implementation
		employees.forEach(new doSomething());
		
		
		// ANONYMOUS class version
		employees.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee emp) {
				System.out.println(emp);
			}
			
		});
		
		
		// LAMBDA version
		employees.forEach((e) -> System.out.println(e));
		
		
		
		
	/* Predicate Interface*/
		// Defines the test() method
		// In order to use the printEmployeesByAge method, you need to
		// pass the implementation in as a parameter.
		printEmployeesByAge(employees, emp -> emp.getAge() > 30);
		
		
		//Pass the SAME predicate as above in the form of an anonymous class
		printEmployeesByAge(employees, new Predicate<Employee>() {

			@Override
			public boolean test(Employee emp) {
				
				return (emp.getAge() > 30);
			}
			
		});
	 
		// Primitive Functional Interface
		IntPredicate greaterThan15 = i -> i > 15;
		System.out.println( "Is 10 greater than 15?\n" + greaterThan15.test(10) );
		
		// Example of Predicate chaining! (Advanced)
		IntPredicate lessThan100 = i -> i < 100;
		System.out.println("Is 10 greater than 15 AND less than 100?\n" + greaterThan15.and(lessThan100).test(10));
	}
	
	

	//Predicate Interface comes from java.util.function
	private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> ageCondition) {
	
		for(Employee e : employees) {
			
			if(ageCondition.test(e)) {
				System.out.println(e.getName() + " passed the predicate test!");
			}
		}
	}

}


class doSomething implements Consumer<Employee>{

	@Override
	public void accept(Employee t) {
		System.out.println(t);
		
	}
		
}