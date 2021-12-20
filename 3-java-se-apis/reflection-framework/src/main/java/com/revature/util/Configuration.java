package com.revature.util;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/*
 * The purpose of this class is to have the user
 * only provide a few things in order for the ORM to
 * establish a connection and build the tables based on
 * a list of User-Defined classes that the user passes to
 * the ORM to introspect and construct in the DB.
 */
public class Configuration {

	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	
	// This is the list of classes that the user wants our ORM
	// to "scan," aka introspect, and build as DB objects.
	private List<MetaModel<Class <?>>> metaModelList;
	
	
	public Configuration addAnnotatedClass(Class annotatedClass) {
		
//		this.dbUrl = dbUrl;
//		this.dbUsername = dbUsername;
//		this.dbPassword = dbPassword;
//		
//		// Maybe call the connection here... up to you!
//		this.getConnection(); // HOWEVER, this does violate the Single Responsibility Principle
//							// You need to keep your methods simple!
		
		// First, check if a linked list has been instantiated;
		// if not, we instantiate it here.
		if(metaModelList == null) {
			metaModelList = new LinkedList<>();
		}
		
		// We need to call the method that transforms a 
		// class into an appropriate data model that our
		// ORM can introspect (A MetaModel)
		metaModelList.add( MetaModel.of(annotatedClass) );
		
		return this; // Returns the configuration object on which the addAnnotationsClass() method is being called
	}
	
	public List<MetaModel <Class <?>>> getMetaModels(){
		
		// In the case that the metaModelList of the configuration object is empty,
		// return an empty list. Otherwise, return the metaModelList.
		return (metaModelList == null) ? Collections.emptyList() : metaModelList;
	}
	
	// Return a connection object OR call on a specific class like Connection Util
	public Connection getConnection(String dbUrl, String dbUsername, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		
		// You can access the above DB credentials which are instance variables
		// of the configuration object.
		// This is up to your creativity -- connect to the database.
		return null;
	}
}
