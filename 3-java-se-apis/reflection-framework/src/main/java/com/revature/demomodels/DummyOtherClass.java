package com.revature.demomodels;

import java.util.Objects;

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
	
	public DummyOtherClass(int testId) {
		super();
		this.testId = testId;
	}

	public DummyOtherClass(int testId, String testField1) {
		super();
		this.testId = testId;
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

	@Override
	public int hashCode() {
		return Objects.hash(testField1, testId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DummyOtherClass other = (DummyOtherClass) obj;
		return Objects.equals(testField1, other.testField1) && testId == other.testId;
	}

	@Override
	public String toString() {
		return "DummyOtherClass [testId=" + testId + ", testField1=" + testField1 + "]";
	}
	
	
	
	
}
