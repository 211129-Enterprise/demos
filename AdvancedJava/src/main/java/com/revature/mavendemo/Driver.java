package com.revature.mavendemo;

import com.revature.annontation.Entity;
import com.revature.inspection.Inspector;
import com.revature.lambda.Employee;

public class Driver {
	// import from our local maven repo 
	public static void main(String[] args) {
		Inspector Ci = new Inspector();
		Ci.listPublicMethods(Employee.class);
		
		Ci.listNonPublicField(Employee.class);
	}
	
	
}
