package com.revature.predicates;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.lambda.Employee;

/*
 * 
 * 
 */

/*
 * consumer , predicate and suplier are all functional  interfaces 
 *  */
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
		employeesList.forEach(null);
		
		// named class 
	//	employeesList.forEach(new doSomthing());
		
		
		// anonomys class 
		/*
		employeesList.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				// TODO Auto-generated method stub
				System.out.println(t);
				
			}
			
		} );
		*/
		// this the lambda way
		employeesList.forEach((e)-> System.out.println(e));
		
		
		// in order to use the printEmployeeByAge method , you need to pass the implementation in as a parameters
		
		
//		printEmployeesByAge(employeesList, emp-> emp.getAge() > 30);
		
//		printEmployeesByAge(employeesList,new Predicate<Employee>() {
//
//			@Override
//			public boolean test(Employee t) {
//				// TODO Auto-generated method stub
//				return t.getAge() > 30;
//			}
//		});
		
		
		
		IntPredicate greaterThan15 = i-> i> 15;
		
		System.out.println("Is 10 greater then 15? " + greaterThan15.test(15));
		
		
		
		IntPredicate lessThan100 =  i -> i<100;
		
		System.out.println("is 10 greater than 15 and less 100 ? " + greaterThan15.and(lessThan100).test(10));
		
		
	}
	
	
	
	
	private static void printEmployeesByAge( List<Employee> employees , Predicate<Employee> ageCondution) {
		
		
		for(Employee e: employees) {
			if(ageCondution.test(e)) {
				System.out.println(e.getName() + " passed the predicate test!");
			}
		}
	}


}



//class doSomthing implements Consumer<Employee>{
//
//	@Override
//	public void accept(Employee t) {
//		// TODO Auto-generated method stub
//		System.out.println(t);
//		
//	}
//	
//}
