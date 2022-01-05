package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao2;

/**
 * Spring @Service annotation is a specialization of Component Annotation
 * 
 * @Service - 
 */

@Service
public class Business2 {
	
	// This business clayer CALLS the data (dao) layer
	
	@Autowired // dependency injection via autowiring and component scanning
	private Dao2 dao2;
	
	public String calculateSomething() {
	
		// strenuous business logic here...
		
		return dao2.retrieveSomething(); // call to the DAO layer
	}
}
