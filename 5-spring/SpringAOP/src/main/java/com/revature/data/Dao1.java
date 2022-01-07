package com.revature.data;

import org.springframework.stereotype.Repository;

/**
 * The Spring @Repository annotation is a specialization of the @Component
<<<<<<< HEAD
 * annotation which indicates that an annotated class is a Repository,
 * which can be used as a mechanism for encapsulating storage, retrieval, and search
 * behavior which emulates a collection of objects.
 */

@Repository
public class Dao1 {

	public String retrieveSomething() {
		
		return "Dao1";
		
	}
=======
 * annotation which indicates that an annotated class is a �Repository�, which
 * can be used as a mechanism for encapsulating storage, retrieval, and search
 * behavior which emulates a collection of objects.
 */
@Repository // Component -> Repository or Service or Controller
public class Dao1 {

	// Whenever this method is called, our Aspect will be triggered and alert us that it's being called
	public String retrieveSomething() {
		
		return "Dao1";
	}
	
>>>>>>> main
}
