package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Id;

public class PrimaryKeyField {
	// this class models the column we're setting up from a class's fields
	
	private Field field;
	
	
	
	public PrimaryKeyField(Field field) {
		
		if(field.getAnnotation(Id.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField object! Provided field, " + 
		field.getName() + "is not annotated with @Id");
		}
		
		this.field = field;
	}
	
	// return the TYPE of the field that's annotated
	public String getName() {
		return field.getName();
	}
	
	public Class<?> getType() {
		return field.getType();		
	}
	
	
	public String getColumnName() {
		return field.getAnnotation(Id.class).columnName();
	}
}
