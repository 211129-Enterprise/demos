package com.demo.dao;

import com.demo.Apple;

/**
  * A repository in terms of Java code is just a dao interface for performing CRUD 
  * operations on ONE type of specific object. For example, this is a repo interface
  * that performs CRUD ops on JUST Apple objects.
  */
public interface AppleRepo extends Dao<Apple>{
	
	// how to call stored procedures from JDBC
	CallableStatement  stmt = conn.prepareCall("{call auotInsert(? , ?)}")

}
