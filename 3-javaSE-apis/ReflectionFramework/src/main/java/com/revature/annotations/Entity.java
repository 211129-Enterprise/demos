package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotations in Java are type of a Marker Interface
 * 
 * Annotations start with an @
 * Annotations do not change the ACTION of a compiled program
 * Annotations are used to associates metadata about the program elements (constructors, fields, methods)
 * Annotations can change the way a program is treated by the compiler
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

	String tableName();
	
}
/*
Retention policies
    - Source (annotation accessible during compilation)
    - Class (annotation accessible during class loading)
    - Runtime (annotation accessible during runtime)
        - used the most in ORM

Target
    - Tells when annotation is valid to be used
*/
