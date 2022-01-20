package com.revature.util;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import com.revature.models.DummyOtherClass;


public class Configuration {
	private List<MetaModel<Class<?>>> metaModelList;
	private ConnectionUtil conn = new ConnectionUtil();
	private ConnectSQL sqlMaker = new ConnectSQL();
	
	public Configuration addAnnotatedClass(Class<?> annotatedClass) {

		if (metaModelList == null) {
			metaModelList = new LinkedList<>();
		}

		metaModelList.add(MetaModel.of(annotatedClass));
		return this; 
	}
	
	public List<MetaModel<Class<?>>> getMetaModels() {
		return (metaModelList == null) ? Collections.emptyList() : metaModelList;
	}
	
	// return a Connection object OR call on a separate class like Connection Util
	public Connection getConnection() throws Exception {
		DataSource d = conn.setUpPool();
		return d.getConnection();
	}

	
	public boolean insertObject(Object o) {
		String sql = sqlMaker.saveSQL(MetaModel.of(o.getClass()));
		System.out.println(sql);
		return true;
	}
	
	public boolean deleteObject(Object o) {
		String sql = sqlMaker.deleteID(o);
		System.out.println(sql);
		return true;
	}
	
	public boolean updateObject(Object o) {
		String sql = sqlMaker.updateSQL(MetaModel.of(o.getClass()));
		System.out.println(sql);
		return true;
	}

	public boolean makeTable(MetaModel<Class<?>> o) {
		String sql = sqlMaker.makeTable(o);
		System.out.println(sql);
		return true;
	}

	public boolean findObject(Object o, String column, String value) {
		String sql = sqlMaker.getBy(o, column, value);
		System.out.println(sql);
		return true;
	}
	
	public boolean getIdObject(Object o) {
		String sql = sqlMaker.getID(o);
		System.out.println(sql);
		return true;
	}
	
}