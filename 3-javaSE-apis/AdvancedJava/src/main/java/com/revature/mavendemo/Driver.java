package com.revature.mavendemo;

import com.revature.inspection.ClassInspector;
import com.revature.lambdas.Employee;

public class Driver {

	public static void main(String[] args) {
		
		// Imported from our local maven repository
		ClassInspector CI = new ClassInspector();
		
		CI.listPublicMethods(Employee.class);
		
		CI.listNonPublicFields(Employee.class);
		
		
	}

}
