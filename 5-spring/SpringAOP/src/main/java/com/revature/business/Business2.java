package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao1;

@Service
public class Business2 {
	
	@Autowired // Dependency injection via autowiring and component scanning
	private Dao1 dao2;
	
	
	// This business layer CALLS the data, dao, layer.
	public String calculateSomething() {
		
		// Strenuous business logic here
		return dao2.retrieveSomething(); // Call to the DAO layer
	}
}
