package com.revature.demomodels;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;

@Entity(tableName="test_table")
public class DummyOtherClass {

	@Id(columnName="test_id")
	private int testId;
	
	@Column(columnName="test_field_1")
	private String testField1;
	
	// there would be constructors, getters, setter, etc.....
	
}
