package com.revature.annontation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 
 * Annotations in java are type of a marker interface
 * 
 * Annotation start with an @
 * 
 * annotation do not used to assocites metadata about the program elemets (constructors , fields, methods)
 * 
 * annotation can change the way a program is treated by the compiler 
 * 
 * 
 * 
 * 
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface Entity {

	String tableName();
	
}

/*
 * Target
 * tells how an annotation can be used ( what type - think on a field or a class)
 * 
 * retentionn policy
 * 
 * source 
 * class
 * runtime the annontation is accessible during run time
 * 	-used most in an ORM
 * 
 * 
 * 
 */

