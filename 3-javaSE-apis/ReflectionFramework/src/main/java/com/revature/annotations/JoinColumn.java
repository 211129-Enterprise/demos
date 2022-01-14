package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinColumn {
	
	String columnName();
	
	/**
	 * The ForeignKeyField.java Class is used to introspect
	 * classes who have properties with the @JoinColumn annotation
	 * and construct a ForeignKeyField object.
	 */

}
