package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Bob");
		Person p2 = new Person("Alice", 22);
		Person p3 = new Person("Eve", 31, 52, 104);
		Person p4 = new Person("Eve", 31, 52, 104);	
		
		p1.introduction();
		p2.introduction();
		p3.introduction();
		
		System.out.println(p3.hashCode());
		System.out.println(p4.hashCode());
		System.out.println(p3 == p4);
		System.out.println(p3.equals(p4));
		
		Person e1 = new Employee("Larry", 25, 6.2, 220, "Finance");
		System.out.println(e1.getName());
	}

}
