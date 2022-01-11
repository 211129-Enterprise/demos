package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.JoinColumn;

public class ForeignKeyField {
	
	private Field field; // from java.lang.reflect
	private MetaModel<Class<?>> ref;
	
	
	public ForeignKeyField(Field field) {
		
		if(field.getAnnotation(JoinColumn.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField object! Provided field, "
					+ getName() + "is not annotated with @JoinColumn");
		}
		this.field = field;
	}
	
	public Field getField() {
		return this.field;
	}
	
	public String getName() {
		return field.getName();
	}
	
	public Class<?> getType() {
		return field.getType();
	}
	
	public String getColumnName() {
		return field.getAnnotation(JoinColumn.class).columnName();
	}

	public MetaModel<Class<?>> getReference() {
		ref = MetaModel.of(field.getAnnotation(JoinColumn.class).references());
		return ref;
	}

	public Object getValue(Object o) throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		return field.get(o);
	}	
}