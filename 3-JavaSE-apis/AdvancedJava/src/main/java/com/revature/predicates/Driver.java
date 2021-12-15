package com.revature.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.lambdas.Employee;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee zayn = new Employee("Zayn Smith", 42);
		
		Employee abby = new Employee("Abby McCormick", 36);
		
		Employee edward = new Employee("Edward Zyrtec", 56);
		
		Employee xavier = new Employee("Xavier Hall", 19);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		
		employees.forEach(new doSomething());
		
		employees.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
			
		});
		
		employees.forEach((e) -> System.out.println(e));
		
		// Predicate Interface defines the test() method
		
		printEmployeesByAge(employees, emp -> emp.getAge() > 30);
		
		printEmployeesByAge(employees, new Predicate<Employee>() {

			@Override
			public boolean test(Employee emp) {
				// TODO Auto-generated method stub
				return emp.getAge() > 30;
			}
			
		});
		
		// primitive functional interfaces
		
		IntPredicate greaterThan15 = i -> i > 15;
		
		System.out.println("is 10 greater than 15" + greaterThan15.test(10));
		
		IntPredicate lessThan100 = i -> i < 100;
		
		System.out.println("Is 10 greater than 15 and less than 100?" + greaterThan15.and(lessThan100).test(10));
	}
	
	private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> ageCondition) {
		for (Employee e : employees) {
			if (ageCondition.test(e)) {
				System.out.println(e.getName() + "passed the predicate test!");
			}
		}
	}

}

class doSomething implements Consumer<Employee> {

	@Override
	public void accept(Employee t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
}
