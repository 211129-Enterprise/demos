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
	
	
	
	public DummyOtherClass() {
		
	}

	public DummyOtherClass(int testId, String testField1) {
		super();
		this.testId = testId;
		this.testField1 = testField1;
	}

	public DummyOtherClass(String testField1) {
		super();
		this.testField1 = testField1;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestField1() {
		return testField1;
	}

	public void setTestField1(String testField1) {
		this.testField1 = testField1;
	}
	
	
}
