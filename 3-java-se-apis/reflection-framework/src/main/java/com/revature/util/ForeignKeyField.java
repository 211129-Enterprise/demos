package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.JoinColumn;

public class ForeignKeyField {
		
		private Field field; // from java.lang.reflect
		
		public ForeignKeyField(Field field) {
			
			if(field.getAnnotation(JoinColumn.class) == null) {
				throw new IllegalStateException("Cannot create ColumnField object! Provided field, "
												+ getName() + ", is not annotated with @JoinColumn.");
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
			return field.getAnnotation(JoinColumn.class).columnName();
		}
	}

