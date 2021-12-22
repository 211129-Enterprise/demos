package com.revature.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.lambdas.Employee;

public class Driver {
	
	public static void main(String[] args) {
		// .forEach(takkes in a consumer object -> provide implementation for accept() method
		
		Employee zayn = new Employee("Zayn Smith", 42);
		Employee abby = new Employee("Abby McCormick", 36);
		Employee edward = new Employee("Edward Zyrtec", 56);
		Employee xavier = new Employee("Xavier Hall", 19);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		employees.add(new Employee("Someone Smith", 22));
		
		employees.forEach(new doSomething());
		
		employees.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
			
		});
		
		//without ever having to define which functionality 
		employees.forEach((emp1) -> System.out.println(emp1));
		
		// predicate interface
		
		printEmployeesByAge(employees, (emp) -> emp.getAge() > 30 );
		
		printEmployeesByAge(employees, new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return t.getAge() > 30;
			}
			
		});
		
		
		// Primitive functional interface
		// functional programming
		IntPredicate greaterThan15 = i -> i > 15;
		int someVar = 10;
		System.out.println("Is 10 greater than 15? " + greaterThan15.test(someVar));
		
		// predicate chaining
		IntPredicate lessThan100 = i -> i < 100;
		System.out.println("Is 10 greater than 15 AND less than 100? " + greaterThan15.and(lessThan100).test(someVar));
		
	}
	// Predicate interface
	// abstract test(t) we are forced to implement
	// Predicate is a functional interface
	private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> ageCondition) {
		
		for(Employee e: employees) {
			if(ageCondition.test(e)) {
				System.out.println(e.getName() + " pass the predicate test!");
			}
		}
	}

}

class doSomething implements Consumer<Employee>{

	@Override
	public void accept(Employee t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
}
