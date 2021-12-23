package com.demo.dao;

import com.demo.Apple;

// A repository in terms of Java code is just an object specific DAO
public interface AppleRepo extends Dao<Apple>{
	
	// how to call stored procedures from JDBC
	CallableStatement  stmt = conn.prepareCall("{call auotInsert(? , ?)}")

}
