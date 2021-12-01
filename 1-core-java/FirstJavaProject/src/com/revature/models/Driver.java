package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		
//		Person p1 = new Person(); // if WE don't provide a constructor, the JVM will automatically create a default-constructor (no-args constructor)
//		Person p2 = new Person();
//		
//		p1.setName("Bob");
//		
//		System.out.println("p1's name is " + p1.getName()); // this will return null because we haven't provided P1 with a name
//		 
//
//		Person p3 = new Person("Jimmy");
//		
//		Person p4 = new Person("Sally", 40, 5.6, 150);
//		Person p5 = new Person("Sally", 40, 5.6, 150); 
//		// will .equals() ring true for the above objects? // tests for value
//		// what about == (testing address in memory)? / NO!
//	
//		
//		p4.introduce();
//		
//		System.out.println(p4);
//		
//		System.out.println("=====================================");
//		
//		System.out.println("Does .equals() return true for both p4 and p5? " + p4.equals(p5)); 
//		// we must OVERRIDE the .equals method inherited from the Object class
//		
//		System.out.println(p4.hashCode());
//		System.out.println(p5.hashCode());
		
		
		System.out.println("Testing function...");
		System.out.println("===================");
		String test = cleanPhoneNumber("1.223.456.7890");
		System.out.println(test);
	}
	
	public static String cleanPhoneNumber(String string) throws IllegalArgumentException {
		int count = 0;
		String base = "";
		String[] stringArr = string.split("");
		for(String element: stringArr) {
			if(Character.isLetter(element.charAt(0))){
				throw new IllegalArgumentException();
			}
			
			if(Character.isDigit(element.charAt(0))) {
				if(element.charAt(0) == '1' && count == 0) {
					
				}
				else {
				    base += element;
				    count++;
				}
				
				System.out.println(count);
				
				
				
				if(count > 10){
					throw new IllegalArgumentException();
				}
			}
			

		}
		
		return base;
	}

}
