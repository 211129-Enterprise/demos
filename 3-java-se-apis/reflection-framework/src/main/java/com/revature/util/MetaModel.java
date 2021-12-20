package com.revature.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;
import com.revature.annotations.JoinColumn;

/*
 * This class' job is to gather as
 * much information about the class we
 * want to transpose into a DB Entity (table)
 * as possible.
 * 
 * This class' job is to model data about
 * another class.
 */
public class MetaModel <T> { // We're inferring that the MetaModel class can only be a meta model
							// of another class.
	
	private Class<?> clazz;
	private PrimaryKeyField primaryKeyField; // We created this "type" in our
											 // com.revature.util package.
	private List<ColumnField> columnFields;
	private List<ForeignKeyField> foreignKeyFields;
	
	
	
	
	// We also need a method to check and then to transpose a
	// normal java class to a MetaModel class.
	// By that, I mean that we need to check for the @Entity
	// annotation.
	public static MetaModel<Class<?>> of (Class<?> clazz){
		
		// We check that the class we're passing through has the @Entity annotation
		if(clazz.getAnnotation(Entity.class) == null) {
			throw new IllegalStateException("Cannot create MetaModel object! The provided class "
											+ clazz.getName() + " is NOT annotated with @Entity.");
		}
		
		// If so... return a new MetaModel object of the class passed through
		return new MetaModel<>(clazz);
		
	}
	
	
	// We only call the constructor when we invoke the
	// MetaModel.of(MyClass.class);
	public MetaModel(Class<?> clazz) {
		
		this.clazz = clazz;
		this.columnFields = new LinkedList();
		this.foreignKeyFields = new LinkedList();
		
	}
	
	// This method will return all the column fields of a metamodel class
	public List<ColumnField> getColumns(){
		// This will return all the properties of that class that are marked 
		// with the @Column annotation
		Field[] fields = clazz.getDeclaredFields();
		
		// For each field within the above Field[], check if it has the Column
		// annotation. If it DOES have the @Column annotation, add it to the meta models'
		// columnField LinkedList
		for(Field field : fields) {
			
			// The column reference variable will NOT be null if the field
			// is annotated with @Column
			Column column = field.getAnnotation(Column.class);
			
			// If it is indeed marked with @Column,
			// instantiate a new ColumnField object
			// with its data.
			if(column != null) {
				columnFields.add(new ColumnField(field));
			}
			
		}
		
		// Add some extra logic in the case that the class doesn't have any column fields
		if(columnFields.isEmpty()) {
			throw new RuntimeException("No columns field found in '" + clazz.getName() + "'");
		} // Ideally, this would be handled...
		
		
		return columnFields;
	}
	
	// As of right now, I have a way to extract the primary key
	// of a MetaModel object.
	public PrimaryKeyField getPrimaryKey() {
		
		// Capture an array of its fields
		Field[] fields = clazz.getDeclaredFields();
		
		// Check if the Id comes back as NOT null
		for(Field field : fields) {
			Id primaryKey = field.getAnnotation(Id.class);
			
			// If primaryKey is NOT null, then generate a
			// PrimaryKeyField object from that field
			if(primaryKey != null) {
				// This will capture the first, and hopefully only, primary key that exists
				return new PrimaryKeyField(field);
			}
		}
		
		// whichever field has the Id annotation, becomes the
		// new PrimaryKeyField object that we want to return
		throw new RuntimeException("Did not find a field annotated with @Id in " + clazz.getName());
		//return primaryKeyField;
	}
	
	
	
	public List<ForeignKeyField> getForeignKeys() {
		
		// Capture an array of its fields
		Field[] fields = clazz.getDeclaredFields();
		
		// Check if the Id comes back as NOT null
		for(Field field : fields) {
			JoinColumn foreignKey = field.getAnnotation(JoinColumn.class);
			
			// If primaryKey is NOT null, then generate a
			// PrimaryKeyField object from that field
			if(foreignKey != null) {
				// This will capture the first, and hopefully only, primary key that exists
				foreignKeyFields.add( new ForeignKeyField(field) );
			}
		}
		
		// whichever field has the Id annotation, becomes the
		// new PrimaryKeyField object that we want to return
		if(foreignKeyFields.isEmpty()) {
			throw new RuntimeException("Did not find a foreign key field annotated with @Id in " + clazz.getName());
		}
		
		return foreignKeyFields;
	}
	
	
	public String getSimpleClassName() {
		return clazz.getSimpleName();
	}
	
	
	
	public String getClassName() {
		return clazz.getName();
	}

}
