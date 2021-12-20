package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 *  ANNOTATION TYPE
 *  Annotations in Java are a type of Marker Interface.
 *  
 *  	- Annotations start with an @ sign
 *  
 *  	- Do not change the behavior of a compiled program
 *  
 *  	- Annotations are used to associate metadata about
 *  	  the program elements (Constructors, fields, methods)
 *  
 *  	- Annotations can change the way a program is treated by
 *  	  the compiler.
 *  
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
	
	String tableName();
	
}

/* TARGET
 * Tells how an annotation can be used / what type - think on a field? a class?
 */
/*
 * Retention Policy
 * 	- Source
 *  - Class
 *  - Runtime: The annotation is acessible during runtime. Most used on an ORM.
 */