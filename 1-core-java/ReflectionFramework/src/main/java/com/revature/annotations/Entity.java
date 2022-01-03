package com.revature.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
	String tableName();
}


/**
 * Target 
 * tells how an annotation can be used (what type - think on a field? a class?
 * 
 * Retention policy
 * 
 * - SOurce
 * - Class
 * - Runtime - the annotation is accessible during runtime
 * used most in an ORM
 * 
 */
