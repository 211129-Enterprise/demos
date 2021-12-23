package com.demo;

import com.revature.util.Configuration; // imported from the extrernal framework for demonstration

public class Driver {

	public static void main(String[] args) {
		
		
		// Here I will demonstrate Configuration
		Configuration cfg = new Configuration();

		cfg.addAnnotatedClass(DemoClass.class); // here's it's building models of all of the classes
												// that I have annotated in my demo app
		
		
		// Maybe in the custom ORM there is some MyORMSession class that would be equal to the JDBC conenction
		MyORMSession ses = cfg.getConnection("jdbc:url:/localhost:5432/postgres", "postgres", "posgres");

		// think of the above as similar to Hibernate's Session interface
		
		// that ses object can now be called in the Demo Dao layer of my app
		
	}

}
