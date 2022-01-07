package com.revature.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.lambdas.Employee;

/* Comsumer, Predicate, and Supplier are all functional interfaces */
public class Driver {

	public static void main(String[] args) {

		// .forEach(takes in a Consumer object) -> provide implementation for accept()
		// method

		// instnatite a few employees here
		Employee zayn = new Employee("Zayn Smith", 42);
		Employee abby = new Employee("Abby McCormick", 36);
		Employee edward = new Employee("Edward Zyrtec", 56);
		Employee xavier = new Employee("Xavier Hall", 19);

		// create some arraylist of employees and add them to it
		List<Employee> employees = new ArrayList<Employee>();

		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		employees.add(new Employee("Someone Smith", 22));

		// passing in the class that explicitly  proivides the implementation
		employees.forEach(new doSomething());

		// Anonymous class version
		employees.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee emp) {
				System.out.println(emp);
			}
		});

		// This is the Lambda way()
		employees.forEach((e) -> System.out.println(e));
		
		// Predicate Interface defines the test() method
		// In order to use the printEmployeesByAge method, you need to pass the implementation in as a parameters
		printEmployeesByAge(employees, emp -> emp.getAge() > 30);
		
		// Pass the SAME predicate as above in the form of an anonymous class
		printEmployeesByAge(employees, new Predicate<Employee>() {

			@Override
			public boolean test(Employee emp) {
				return emp.getAge() > 30;
			}

		});
		
		// Primitive Functional Interface
		IntPredicate greaterThan15 = i -> i > 15; 
		int someVar = 10;
		System.out.println("Is 10 greater than 15? " + greaterThan15.test(someVar));
		
		// Predicate chaining! - advanced
		IntPredicate lessThan100 = i -> i < 100;
		System.out.println("Is 10 greater than 15 AND less than 100? " + greaterThan15.and(lessThan100).test(someVar));
		
		
	}
	
	// Predicate Interface comes from java.util.function
	private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> ageCondition) {
		
		for (Employee e : employees) {
			
			if (ageCondition.test(e)) {
				
				System.out.println(e.getName() + " passed the predicate test!");
				
			}
			
		}
		
	}
}

class doSomething implements Consumer<Employee> {

	@Override
	public void accept(Employee t) {
		System.out.println(t);

	}

}
