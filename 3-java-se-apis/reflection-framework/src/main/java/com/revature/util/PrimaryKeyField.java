package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Id;

public class PrimaryKeyField {
	
	private Field field; // from java.lang.reflect
	
	public PrimaryKeyField(Field field) {
		
		if(field.getAnnotation(Id.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField object! Provided field, "
											+ getName() + ", is not annotated with @Id.");
		}
		this.field = field;
	}
	
	// Return the name
	public String getName() {
		return field.getName();
	}
	
	// Return the data type
	public Class<?> getType(){
		return field.getType();
	}
	
	// Get columnName() = extract the column name attribute from the @Column annotation
	public String getColumnName() {
		return field.getAnnotation(Id.class).columnName();
	}

}
