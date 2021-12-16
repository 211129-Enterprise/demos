package com.revature.doublylinkedlist;

public class Node {
	
	public int data;
	public Node next; // single linked list
	public Node previous; // Double linked list
	
	public void displayNode() {
		
		System.out.println("{ " + data + " }");
	
	}
	
}
