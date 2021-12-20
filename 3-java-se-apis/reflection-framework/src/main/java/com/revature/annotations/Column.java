package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
Retention Policies
- Source (Annotation accessible during compilation)
- Class (annotation accessible during class loading)
- Runtime (annotation accessible during runtime)
- used the most in ORM

Target
- Tells when annotation is valid to be used.
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	String columnName();
	
}

/*
 * INTROSPECTION vs REFLECTION
 * 
 *   - Introspection examines.
 *   - Reflection modifies.
 * 
 * Introspection is the ability of a program to examine the type or properties
 * of an object at runtime.
 * 
 * Reflection is the ability of a program to examine and modify the structure and
 * behavior of an object at runtime.
 */

