package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {
	public static void main(String[]args) {
		
		Employee zayn = new Employee("Zayn Smith", 42);
		Employee abby = new Employee("Abby McCormick", 36);
		Employee edward = new Employee("Edward Zyrtec", 58);
		Employee xavier = new Employee("Xavier Hall", 19);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		
		employees.forEach(System.out::println);
		
		//Anonymous Class
		Collections.sort(employees, new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		//Not very elegant, calls class into memory to use one method
		Collections.sort(employees, new NameSorter());
		
		//Best way
		Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
	}
}

class NameSorter implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class AgeSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return 0;
	}	
}