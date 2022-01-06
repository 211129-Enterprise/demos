package com.demo;

import com.revature.annotations.Entity; // this is now imported from my custom ORM

@Entity(tableName="test_table")
public class DemoClass {

	@Id
	private int id;
	
}
