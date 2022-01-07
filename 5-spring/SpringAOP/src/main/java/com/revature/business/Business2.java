package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao2;

/**
<<<<<<< HEAD
 * Spring @Service annotation is a specialization of Component Annotation
 * 
 * @Service - 
=======
 * Spring @Service annotation is a specialization of @Component annotation.
 * 
 * @Service annotation is used in your service layer and annotates classes that
 *          perform service tasks, this annotation to represent a best practice.
 *          For example, you could directly call a DAO class to persist an
 *          object to your database but this is horrible. It is pretty good to
 *          call a service class that calls a DAO. This is a good thing to
 *          perform the separation of concerns pattern.
>>>>>>> main
 */

@Service
public class Business2 {
	
<<<<<<< HEAD
	// This business clayer CALLS the data (dao) layer
=======
	// This business layer CALLS the data (dao) layer
>>>>>>> main
	
	@Autowired // dependency injection via autowiring and component scanning
	private Dao2 dao2;
	
	public String calculateSomething() {
<<<<<<< HEAD
	
=======
		
>>>>>>> main
		// strenuous business logic here...
		
		return dao2.retrieveSomething(); // call to the DAO layer
	}
}
