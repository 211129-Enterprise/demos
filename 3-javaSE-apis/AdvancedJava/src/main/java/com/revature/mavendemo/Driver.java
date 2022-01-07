package com.revature.mavendemo;

import com.revature.inspection.ClassInspector;
import com.revature.lambdas.Employee;

public class Driver {

	public static void main(String[] args) {

		ClassInspector cI = new ClassInspector();
		
//		cI.listPublicMethods(Employee.class);
		
		cI.listNonPublicFields(Employee.class);
		
	}

}
