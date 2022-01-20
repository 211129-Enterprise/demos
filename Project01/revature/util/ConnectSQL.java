package com.revature.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import com.revature.annotations.Column;
import com.revature.annotations.Entity;

public class ConnectSQL {

	private static HashMap<String, String> types = new HashMap<String, String>();
	Connection conn = (Connection) ConnectionUtil.getConnectionPool();
	static {
		types.put("integer", "INTEGER");
		types.put("int", "INTEGER");
		types.put("long", "BIGINT");
		types.put("short", "INTEGER");
		types.put("float", "FLOAT");
		types.put("double", "NUMERIC");
		types.put("bigdecimal", "NUMERIC");
		types.put("character", "CHAR(1)");
		types.put("string", "VARCHAR");
		types.put("byte", "TINYINT");
		types.put("boolean", "BOOLEAN");
		types.put("date", "DATE");
		types.put("time", "TIME");
		types.put("timestamp", "TIMESTAMP");
		types.put("calendar", "TIMESTAMP");
		types.put("calendardate", "DATE");
		types.put("binary", "BLOB");
		types.put("text", "CLOB");
		types.put("serializable", "BLOB");
		types.put("clob", "CLOB");
		types.put("blob", "BLOB");
		types.put("class", "VARCHAR");
		types.put("locale", "VARCHAR");
		types.put("timezone", "VARCHAR");
		types.put("currency", "VARCHAR");
	}

	public String makeTable(MetaModel<Class<?>> claxx) {
		String sql = "";
		if (claxx != null) {
			sql += "CREATE TABLE IF NOT EXISTS " + claxx.getClazz().getAnnotation(Entity.class).tableName() + " (\n";
			PrimaryKeyField pmk = claxx.getPrimaryKey();
			sql += pmk.getColumnName() + " SERIAL PRIMARY KEY";

			for (ColumnField c : claxx.getColumns()) {
				sql += ",\r\n";
				sql += c.getColumnName() + " " + types.get(c.getType().getSimpleName().toLowerCase());
				if (c.getType().getAnnotation(Column.class) != null
						&& c.getType().getAnnotation(Column.class).notNull()) {
					sql += " NOT NULL";
				}
				if (c.getType().getAnnotation(Column.class) != null
						&& c.getType().getAnnotation(Column.class).Unique()) {
					sql += " UNIQUE";
				}
			}
			if (claxx.getForeignKeys() != null && !claxx.getForeignKeys().isEmpty()) {

				for (ForeignKeyField key : claxx.getForeignKeys()) {
					sql += ",\r\n";
					sql += key.getColumnName() + " INTEGER REFERENCES ";
					sql += key.getReference().getClazz().getAnnotation(Entity.class).tableName() + "("
							+ key.getReference().getPrimaryKey().getColumnName() + ")";
					sql += " ON UPDATE CASCADE ON DELETE CASCADE";
				}
			}
			sql += "\r\n);";
		}
		return sql;
	}

	public String findBySQL(MetaModel<Class<?>> claxx) {
		return "SELECT * FROM " + claxx.getClazz().getAnnotation(Entity.class).tableName() + " WHERE ";
	}
	
	//Get by ID ==============================================================================================================================================
	public String getID(Object o) {
		MetaModel<Class<?>> claxx = MetaModel.of(o.getClass());
		String sql1 = findBySQL(claxx);
		String sql2 = claxx.getClazz().getAnnotation(Entity.class).tableName() + ".id = ? \n";
		String sql = sql1 + sql2;
		
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setObject(1, claxx.getPrimaryKey().getValue(o));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
		return sql;
	}
	
	//Get by WHATEVER I want =====================================================================================================================================
	public String getBy(Object o, String column, String value) {
		MetaModel<Class<?>> claxx = MetaModel.of(o.getClass());
		String sql1 = findBySQL(claxx);
		String sql2 = claxx.getClazz().getAnnotation(Entity.class).tableName() + "." + claxx.getColumn(column).getColumnName()+ " = ? \n";
		String sql = sql1 + sql2;
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setObject(1, value);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		}
		return sql;
	}

	public String findAllSQL(MetaModel<Class<?>> claxx) { // done
		return "SELECT * FROM " + claxx.getClazz().getAnnotation(Entity.class).tableName() + ";";
	}

	//Update SQL ==========================================================================================================================================
	public String updateSQL(MetaModel<Class<?>> claxx) {
		String sql = "UPDATE ";
		sql += claxx.getClazz().getAnnotation(Entity.class).tableName() + "\r\nSET ";
		List<String> columns = claxx.getColumnNameList();
		sql += columns.stream().collect(Collectors.joining(" = ? , ")) + " = ?\r\n";
		sql += "WHERE " + claxx.getPrimaryKey().getColumnName() + " = ?;";
		return sql;
	}
	
	//Inserting Objects ===================================================================================================================================
	public String saveSQL(MetaModel<Class<?>> claxx) {
		String sql = "INSERT INTO ";
		sql += claxx.getClazz().getAnnotation(Entity.class).tableName() + " (";
		List<String> columns = claxx.getColumnNameList();
		sql += columns.stream().collect(Collectors.joining(", ")) + ") VALUES " + "("
				+ columns.stream().map(c -> "?").collect(Collectors.joining(", ")) + ") ON CONFLICT DO NOTHING" + "\n";
		
		return sql;
	}
	
	public String deleteSQL(MetaModel<Class<?>> claxx) {
		return "DELETE FROM " + claxx.getClazz().getAnnotation(Entity.class).tableName() + " WHERE ";

	}
	
	//Delete By ID =====================================================================================================================================================
	public String deleteID(Object o) {
		MetaModel<Class<?>> claxx = MetaModel.of(o.getClass());
		String sql1 = deleteSQL(claxx);
		String sql2 = claxx.getClazz().getAnnotation(Entity.class).tableName() + ".id = ? \n";
		String sql = sql1 + sql2;

//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setObject(1, claxx.getPrimaryKey().getValue(o));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
		
		//UNDO WHEN READY -----------------------------------------
		
		return sql;
	}

}