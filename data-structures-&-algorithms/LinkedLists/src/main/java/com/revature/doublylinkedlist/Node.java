package com.revature.doublylinkedlist;

public class Node {
	
	public int data;
	public Node next; // pointer to next Node
	public Node previous; // pointer to previous Node
	
	public void displayNode(){
		System.out.print("{ "+ data + " } ");
	}
	
}
