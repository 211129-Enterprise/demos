package com.revature.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;
import com.revature.annotations.JoinColumn;

/**
 * This class's job is to gather as much information as possible about the class we want
 * to transpose into a DB Entity (table).
 * 
 * This class's job is to model data about another class.
 */
public class MetaModel<T> { // we're inferring that the MetaModel class can only be a metamodel of another class
	
	private Class<?> clazz;
	private PrimaryKeyField primaryKeyField; // we created this "type" in our com.revature.util package
	private List<ColumnField> columnFields;
	private List<ForeignKeyField> foreignKeyFields;
	
	// a method to check and then transpose a normal java class to a MetaModel class
	// to check for the Entity annotation
	public static MetaModel<Class<?>> of(Class<?> clazz) {
		
		// we check that the class we're passing through has the @Entity annotation
		if (clazz.getAnnotation(Entity.class)== null ) {
			throw new IllegalStateException("Cannot create MetaModel object! Provided class " + 
					clazz.getName() + " is not annotated with @Entity");
		}
		// if so...
		
		return new MetaModel<>(clazz);
	}
	
	// we only call the constructor when we invoke the MetaModel.of(MyCLass.class);
	public MetaModel(Class<?> clazz) {
	
		this.clazz = clazz;
		this.columnFields = new LinkedList<>();
		this.foreignKeyFields = new LinkedList<>();	
		
	}
	
	// this method will return all the column fields of a MetaModel class
	public List<ColumnField> getColumns() {
		// this method returns all the properties of the class that are marked with @Column annotation
		
		Field[] fields = clazz.getDeclaredFields();
		
		// for each field within the above Field[], check if it has the Column annotation
		// if it DOES have the @Column annotation add it to the metamodel's columnFields LinkedList
		for (Field field : fields) {
			
			// The column reference variable will NOT be null, if the field is annotated with @Column
			
			Column column = field.getAnnotation(Column.class);
			
			if (column != null) {
				// if it is indeed marked with @Column, instantiate a new ColumnField object with its data
				columnFields.add(new ColumnField(field));
				
			}
		}
		
		// add some extra logic in the case that the class doesn't have any ColumnFields.
		if (columnFields.isEmpty()) {
			throw new RuntimeException("No columns found in: " + clazz.getName());
		}
		
		return columnFields;
	}
	
	// if we want to fetch the primary key
	public PrimaryKeyField getPrimaryKey() {
		// capture an array of its fields
		Field[] fields = clazz.getDeclaredFields();
		// check if the Id comes back as NOT null
		for (Field field : fields) {
			Id primaryKey = field.getAnnotation(Id.class);
			
			//IF primaryKey is NOT null, then generate a PrimaryKeyField object from that field
			if (primaryKey != null) {
				// this will capture the first and (hopefully) only primary key that exists
				return new PrimaryKeyField(field);
			}
		}
		// whichever field has the Id annotation, becomes the new PrimaryKeyField object we return
		throw new RuntimeException("Did not find a field annotated with @Id in " + clazz.getName());
	}
	
	public List<ForeignKeyField> getForiegnKeys() {
				Field[] fields = clazz.getDeclaredFields();
				
				for (Field field : fields) {
					
					JoinColumn foreignKey = field.getAnnotation(JoinColumn.class);
					
					if (foreignKey != null) {
						// if it is indeed marked with @Column, instantiate a new ColumnField object with its data
						foreignKeyFields.add(new ForeignKeyField(field));
						
					}
				}
				
				// add some extra logic in the case that the class doesn't have any ColumnFields.
				if (columnFields.isEmpty()) {
					throw new RuntimeException("No columns found in: " + clazz.getName());
				}
				
				return foreignKeyFields;
	}
	
	public String getSimpleClassName() {
		return clazz.getSimpleName();
	}
	
	public String getClassName() {
		return clazz.getName();
	}
	
<<<<<<< Updated upstream:3-JavaSE-apis/ReflectionFramework/src/main/java/com/revature/util/MetaModel.java
=======
	public String getTableName() {
		return !this.clazz.getAnnotation(Entity.class).tableName().isBlank() ? this.clazz.getAnnotation(Entity.class).tableName() : this.getSimpleClassName().replaceAll("([a-z])([A-Z]+)","$1_$2").toLowerCase() + "s" ;
	}

>>>>>>> Stashed changes:3-javaSE-apis/ReflectionFramework/src/main/java/com/revature/util/MetaModel.java
}
