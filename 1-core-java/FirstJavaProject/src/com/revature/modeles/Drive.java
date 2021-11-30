package com.revature.modeles;

public class Drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person();
		Person p2 = new Person();
		
		System.out.println(p1.getName() + "here");
		
		Person p4 = new Person("sally", 40, 5.6, 3.9);
		Person p5 = new Person("sally", 40, 5.6, 3.9);
		
		
		System.out.println(p4.equals(p5) + "  equality ") ;
		System.out.println(p5.hashCode());
		System.out.println(p4.hashCode());
		
		
		p4.itroduce();
		
		System.out.println(p4);
		
	
		
		
	}

}
