package com.revature.otherpackage;

import com.revature.accessmods.ClassA;

public class ClassC extends ClassA{
	
	public static void main(String[] args) {
		
		ClassA classA = new ClassA();
				
		System.out.println(classA.publicField);
		//System.out.println(classA.privateField); //we can't access the private field because we're not in the ClassA		                                         //Class file.
		//System.out.println(classA.defaultField);
	    //System.out.println(classA.protectedField); //we could access the protected field by first extending ClassA from Class C
	                                               //Then instantiate classC 
	                                               //then sysout
	    ClassC classC = new ClassC();
	    
	    //System.out.println(classC.defaultField); // can't access this because even though ClassC is a subclass, its in a 
	                                             //different package.
	    System.out.println(classC.protectedField); // this field is inherited from classA because that's the parent
		
	}

}
