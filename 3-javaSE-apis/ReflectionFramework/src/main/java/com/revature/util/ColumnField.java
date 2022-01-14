package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Column;

/**
 * The purpose of this class is to extract
 * fields of a class marked with the @Column
 * annotation which I've defined in my annotations
 * package.
 * 
 * I'll use this class to extract the data type of those
 * fields so I get a better idea of what SQL TYPE constraints
 * would best represent that column in a database.
 */
public class ColumnField {
	// this class models the column we're setting up from a class' fields
	
	private Field field; // from java.lang.reflect
	
	
	public ColumnField(Field field) {
		
		if(field.getAnnotation(Column.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField object! Provided field, "
					+ getName() + "is not annotated with @Column");
		}
		this.field = field;
	}
	
	public String getName() {
		return field.getName();
	}
	
	// return the TYPE of the field that's annotated
	public Class<?> getType() {
		return field.getType();
	}
	
	// get columnName() -=- extract the column name attribute from the column annotation
	public String getColumnName() {
		return field.getAnnotation(Column.class).columnName();
	}
}
