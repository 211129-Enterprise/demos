package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Employee zayn = new Employee("Zayn Smith", 42);
		
		Employee abby = new Employee("Abby McCormick", 36);
		
		Employee edward = new Employee("Edward Zyrtec", 56);
		
		Employee xavier = new Employee("Xavier Hall", 19);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		
		employees.forEach(System.out::println);
		
//		Collections.sort(employees, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// TODO Auto-generated method stub
//				
//				return o1.getName().compareTo(o2.getName());
//			}
//		
//		});
		
//		Collections.sort(employees, new NameSorter());
		
		Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));

	}

}

class NameSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}

class AgeSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getAge() < o2.getAge() ? -1 : o1.getAge() > o2.getAge() ? 1 : 0;
	}
	
}