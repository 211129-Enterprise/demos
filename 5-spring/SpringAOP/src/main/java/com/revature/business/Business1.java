package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao1;

@Service
public class Business1 {
	
<<<<<<< HEAD
	// This business clayer CALLS the data (dao) layer
	
	@Autowired // dependency injection via autowiring and component scanning
	private Dao1 dao1; // Spring automatically understands that a DAO object BELONGS to this class so that it can call its methods
	
	public String calculateSomething() {
	
		// strenuous business logic here...
		
		return dao1.retrieveSomething(); // call to the DAO layer
	}
=======
	// This business layer CALLS the data (dao) layer
	
	@Autowired // dependency injection via autowiring and component scanning
	private Dao1 dao1; // Spring automatically understands that a DAO object BELONGS to this class so that we can call its methods
	
	public String calculateSomething() {
		
		// strenuous business logic here...
		return dao1.retrieveSomething(); // call to the DAO layer

	}
	
	
>>>>>>> main
}
