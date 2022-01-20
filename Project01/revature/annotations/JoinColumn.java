package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinColumn {

	String columnName() default "";
	
	String joinColumns() default "";
	
	String inverseJoinColumns() default "";

	String foreignKey() default "";
	
	Class<?> references();
}
