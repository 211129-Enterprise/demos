package com.revature.demoMyORM;

import com.ormv.inspection.ClassInspector;
import com.revature.lambdas.Employee;

public class Driver {
	
	public static void main(String[] args) {
		ClassInspector CI = new ClassInspector();
		
		CI.listPublicConstructors(Employee.class);
		
		CI.listNonPublicFields(Employee.class);
	}
	
	
	

}
