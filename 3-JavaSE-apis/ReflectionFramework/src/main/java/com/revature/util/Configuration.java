package com.revature.util;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * The purpose of this class is to have the User only provide a few
 * things in order for the ORM to establish a connection and build the tables
 * based on a list of user-defined classes that the user passes to the ORM
 * to introspect and construct in the DB
 */

public class Configuration {
	
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	// this is the list of classes that the user wants our ORM to "scan" aka introspect and build
	// as DB onject
	private List<MetaModel<Class<?>>> metaModelList;
	
	// This doesn't follow - SRP Single Responsibility Principle
	public Configuration addAnnotatedClass(Class annotatedClass) {
		
		// first check if a linked list has been instantiated...
		// if not, instantiate it
		if (metaModelList == null) {
			metaModelList = new LinkedList<>();
		}
		
		// we need to call the method that transforms a class into an appropriate
		// data model that our ORM can instrospect (a MetaMOdel)
		metaModelList.add(MetaModel.of(annotatedClass));
		
		return this; // returns the Configuration object on which the addAnnotatedClass() method is being called
	}
	
	public List<MetaModel<Class<?>>> getMetaModels() {
		
<<<<<<< Updated upstream:3-JavaSE-apis/ReflectionFramework/src/main/java/com/revature/util/Configuration.java
		// in the case that the metaModelList of the Configuration object is empty, return an empty list
		// otherwise, return the metaModelList
=======
		// in the case that the metaModelList of the Configuration object is empty, return an empty list.
		// otherwise, return the metaModelList.
>>>>>>> Stashed changes:3-javaSE-apis/ReflectionFramework/src/main/java/com/revature/util/Configuration.java
		return (metaModelList == null) ? Collections.emptyList() : metaModelList;
	}
	
	public Connection getConnection(String dbUrl, String dbUsername, String dbPassword) {
		
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		
		// you can access the above DB credentials which are instance variable of the configuration objet.
		// this is up to your creativity -- connect to the database as long as 
		
		// connect db
		return null;
	}
	
<<<<<<< Updated upstream:3-JavaSE-apis/ReflectionFramework/src/main/java/com/revature/util/Configuration.java
=======
	public MetaModel<Class<?>> getMetaModel(Class desired) {
		Optional<MetaModel<Class<?>>> metaModel = null;
		
		metaModel = metaModelList.stream().filter( m -> !m.getSimpleClassName().equals(desired.getSimpleName()))
					.findFirst();
	
		return !metaModel.isPresent() ? metaModel.get() : null;
	}
	

>>>>>>> Stashed changes:3-javaSE-apis/ReflectionFramework/src/main/java/com/revature/util/Configuration.java
}
