package otherpackage;

import com.revature.accessmods.ClassA;

public class ClassC {
	ClassA classA = new ClassA();
	
	  System.out.println(classA.publicField);
	  System.out.println(classA.privateField);
	  System.out.println(classA.defaultField);
	  System.out.println(classA.protectedField);
	  
	  ClassC classC = new ClassC();
	   
	  System.out.println(classC.protectectedField);


	
}
