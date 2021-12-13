package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		//instantiate new employees
		Employee zayn  = new Employee("Zayn Smith", 42);
		Employee abby  = new Employee("Abby McCormick", 36);
		Employee edward  = new Employee("Edward Zyrtec", 56);
		Employee xavier  = new Employee("Xavier Hall", 19);
		
		
		//create an array list of employees amd add them to it
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		employees.add(new Employee("Someone Smith", 22));
		
		//method referencing
		employees.forEach(System.out::println);
		
		Collections.sort(employees, new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) { // it's compare(), not compareTo()  
				//sort by employee name in ascending order
				//class already implements the comparable interface.
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		//With a NameSorter Class
//	Collections.sort(employees, new NameSorter());
		//This is a waste only to call a compare method. Use a lambda expression.
		Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName())
			//put the sorting functionality here for not one line form.
			
		);
	}
	
}

//class NameSorter implements Comparator<Employee> {
//	@Override
//	public int compare(Employee o1, Employee o2) { // it's compare(), not compareTo()  
//		//sort by employee name in ascending order
//		//class already implements the comparable interface.
//		return o1.getName().compareTo(o2.getName());
//	}
//	
//}
