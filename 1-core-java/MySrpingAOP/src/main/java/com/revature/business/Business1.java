package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao1;

@Service
public class Business1 {

	// business 1 will talk to dao 1
	// we inject that dependency via autowired and component scanning

	@Autowired
	private Dao1 dao1; 

	public String calculateSomething() {
		return dao1.retrieveSomething();
	}
}
