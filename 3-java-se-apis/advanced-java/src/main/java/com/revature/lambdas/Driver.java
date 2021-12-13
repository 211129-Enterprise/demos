package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		
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
		
		
		// Method referencing - calling method on each obj in data structure
		System.out.println("========== UNSORTED LST ==========");
		employees.forEach(System.out::println);
		
		
		// Anonymous Class version of sort
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				
				// Sort by Employee name in ascending order
				return o1.getName().compareTo(o2.getName());
			}	
		});
		
		
		
		// Using the NameSorter class to sort
		Collections.sort(employees, new NameSorter());
		
		
		
		// Using lambdas to sort
		Collections.sort( employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()) );
//		
		//or
//		
//		Collections.sort(employees, (emp1, emp2) -> {
//			//Put sorting functionality here
//		});
		
		
		// Calling the AgeSorter class
		Collections.sort(employees, new AgeSorter());
		
		
		// Outputting the sorted list
		System.out.println("\n\n========== WITH AGE SORTER ==========");
		employees.forEach(System.out::println);

	}

}


// Inoptimal as you must load the class and then an instance of its method in order
// to perform a sort. The "Best way" is considered to be via lambda expressions like above.
class NameSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) { // Notice it is compare() and NOT compareTo()
		
		// Sort by Employee name in ascending order
		// by leveraging the String class' compareTo
		// method because that class already implements
		// the comparable interface.
		return o1.getName().compareTo(o2.getName());
	}
	
	
	
}

class AgeSorter implements Comparator<Employee>{ // Only use this class with instances of Employees

	@Override
	public int compare(Employee o1, Employee o2) {

		// Prints out in ascending order
		return o1.getAge() < o2.getAge() ? -1 		// If first object is less than second, return -1
				: o1.getAge() > o2.getAge() ? 1		// If first object is more than second, return 1
						: 0;						// Else, return 0
	} 
	
	
}