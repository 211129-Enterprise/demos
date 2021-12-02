package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String stringObject1 = new String("Straight to the general we go"); //In the general heap!
		System.out.println(stringObject1);
		
		String str1 = "Hello"; //String literal -> string pool
		String str2 = "Hello"; //Here, no new string object is created as the JVM checks 
							   //if string object matching its exact pattern exists in the string pool
		
		System.out.println("Does st1 have the same value as str2?" + str1.equals(str2)); //TRUE
		
		// Do they point to the same location in memory?
		System.out.println("Is str1 the same object as str2?" + (str1 == str2)); //TRUE
		
		//Up to this point only 2 objects have been created
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		//This string object goes to the general heap
		String stringObject2 = new String("Hello");
		System.out.println("Is str1 the same object as str3?" + (str1 == stringObject2)); //FALSE
		//String 3 is in a separate location in memory in the heap outside the string pool
		
		String str3 = "Hello World";
		String str4 = "Hello" + " World"; //This is NOT a mutation
		
		// Do they point to the same location in memory?
		System.out.println("Is str1 the same object as str2?" + (str3 == str4)); //TRUE
		
		//Even though the memory address is different,
		//REMEMBER that the hashcode is NOT the address
		//in memory
		System.out.println(stringObject2.hashCode()); //69609650
		System.out.println(str2.hashCode()); //69609650
		//Same value of properties but NOT the same location in memory
		
		String str5 = "Hello";
		String str6 = str5 + " World"; //This IS a mutation as we're appending one string to another
									   //str6 is sent to the general heap.... 
									   //it's equiv to String str6 = new String();
		
		System.out.println(str6 == str3); //FALSE
		
		//Let's send str6 to the string pool
		String str6inPool = str6.intern(); //This returns a string object that matches the pattern of the gen
										   //heap object and this reference variable now points to it
		
		System.out.println(str6inPool == str3);
		
		
		/**
		 *  String API
		 *  
		 *  - concat()
		 *  - substring()
		 *  - charAt()
		 *  - split()
		 *  - isEmpty()
		 *  - length()
		 */
		
		String newStrObject = str6inPool.concat("some garbage"); //Sent to gen heap
		System.out.println(newStrObject);
		
		String test = "The quick brown fox jumped over the lazy dog";
		String chopped = test.substring(7);
		System.out.println(chopped); //Outputs "ck brown fox jumped over the lazy dog"
		
		//These are mutable versions of the String class
		// StringBuffer - thread safe and slower (synchronized)
		// String Builder - NOT thread safe and faster (not synchronized)
		//
		// *** Think of thread safe as having order / taking turns ***
		// "You don't want the book to change as you're reading it"
		
		StringBuilder sbuild = new StringBuilder("Hello");
		sbuild.append(" ");
		sbuild.append("World"); //The same object that has been mutated
		
		System.out.println("StringBuilder! " + sbuild);
		
		// How do we send this string object to the string pool?
		//   Step 1 - We convert to a string object (from the String class)
		String buildToString = sbuild.toString();
		
		//buildToString is in the general heap but...
		String sbInPool = buildToString.intern(); //..now it has been sent to string pool
		System.out.println(sbInPool == str6inPool); //TRUE
		
		
	}
	
}
