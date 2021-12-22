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
		
		// linkedlist take up more memory. node base structure. so pointer pointing to neighbourly node.
		// 
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(zayn);
		employees.add(abby);
		employees.add(edward);
		employees.add(xavier);
		employees.add(new Employee("Someone Smith", 22));
		// simplest way to specify lambda
		// method referencing, premeir value or reference type
		employees.forEach(System.out::println);
		
		
		// anpnymous class:
		// capable for comapring two different classes/
		// compare than compare to. difference
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// sort by Employee name in ascending order
				
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		// wiith the namesort class *3
		Collections.sort(employees, new NameSorter());
		
		// "the best way"
		Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
		
		Collections.sort(employees, (emp1, emp2) -> {
			return emp1.getName().compareTo(emp2.getName());
		});
		
		Collections.sort(employees, new AgeSorter());
		
		System.out.println( "===== With AGE SORTER =======");
		
		employees.forEach(System.out::println);
		
	}

}

// bit of a waste for memory *3
class NameSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}

class AgeSorter implements Comparator<Employee>{
	
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getAge() < o2.getAge() ? -1
				: o1.getAge() > o2.getAge() ? 1
					: 0;
	}
}
