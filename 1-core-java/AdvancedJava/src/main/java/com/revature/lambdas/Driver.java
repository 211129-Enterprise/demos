package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		
		
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

		// Method Referencing 
		employees.forEach(System.out::println);
		
		// Anonymous Class!
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) { // notice it's compare() and not compareTo()
				// sort by Employee Name in ascending order by leveraging the String class' compareTo mehtod because that
				// class already implements the comparable interface 
				return o1.getName().compareTo(o2.getName());
			} 
		
		});
		
		// With the NameSorter class
		Collections.sort(employees, new NameSorter());
		
		// The "best way" is via a Lambda Expression
		Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
		
		// here I'm calling the AgeSorter Class
		Collections.sort(employees, new AgeSorter());
		
		System.out.println("====== With Age Sorter =======");
		
		employees.forEach(System.out::println);
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