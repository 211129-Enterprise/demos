package com.revature.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.lambdas.Employee;

// Consumer, Predicate, and Supplier are all functional interfaces
public class Driver {

	public static void main(String[] args) {
		// .forEach(takes in a consumer object) -> provide implementation for accept() method
		
		// instantiate a few employees here
		Employee zayn = new Employee("Zayn Smith", 42);
		Employee abby = new Employee("Abby McCormick", 36);
		Employee edward = new Employee("Edward Zyrtec", 56);
		Employee xavier = new Employee("Xavier Hall", 19);		
		
		// create an arraylist of employees and add
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		employees.add(new Employee("Someone Smith", 22));
	
		employees.forEach(new doSomething());
		System.out.println("===");
		// Anonymous Class version
		employees.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				System.out.println(t);
			}
			
			
		});
		System.out.println("===");
		// Lambda
		employees.forEach((e) -> System.out.println(e));
		
		// Predicate Interface defines the test() method
		// in order to use the PrintEmployeesByAge, you need to pass the implementation in as a parameter.
		System.out.println("===");
		printEmployeesByAge(employees, emp -> emp.getAge() > 30);
		System.out.println("===");
		printEmployeesByAge(employees, new Predicate<Employee>() {

			@Override
			public boolean test(Employee emp) {
				return emp.getAge() > 30;
			}
			
		});
		
		// Primitive Functional Interface
		IntPredicate greaterThan15 = i -> i > 15;
		System.out.println("Is 10 greater than 15? " + greaterThan15.test(10));
		
		IntPredicate lessThan100 = i -> i < 100;
		System.out.println("Is 10 greater than 15 and less than 100? " + greaterThan15.and(lessThan100).test(10));
		
		
	}

	private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> ageCondition ) {
		
		for (Employee e: employees) {
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