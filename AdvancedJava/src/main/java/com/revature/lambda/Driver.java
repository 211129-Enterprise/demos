package com.revature.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> employeesList = new LinkedList<>();
		
		Employee zayn = new Employee("Zayn Smith", 42);
		Employee abby = new Employee("Abby Mac", 36);
		Employee edward = new Employee("Edward Zyr", 36);
		Employee xavier = new Employee("Xavier Hall", 19);
		
		employeesList.add(zayn);
		employeesList.add(abby);
		employeesList.add(edward);
		employeesList.add(xavier);
		
		
		// using a named class
//		Collections.sort(employeesList, new NameSorted() );
//		
		
		
		employeesList.forEach(System.out:: println);
		Collections.sort(employeesList, (emp1, emp2)-> emp1.getName().compareTo(emp2.getName()));
		employeesList.forEach(System.out:: println);
		
		System.out.println("=======================>");
		
//		Collections.sort(employeesList, new AgeSorted());
		
		
		
		// with anonymous class 
		
		Collections.sort(employeesList, new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
			
		} );
	
	
		
		
	}
	
	// with the name class
	
	
	
	
	class NameSorted implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	
	class AgeSorted implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.getAge()< o2.getAge() ? -1 :
				o1.getAge() > o2.getAge() ? 1 
						:0
				;
		}
		
		
		
	}
	
	

}
