package com.revature.singlylinkedlist;

public class Node {
    int data; // Imagine that each element in this Linked List is an Integer
	public Node next; // Represents neighboring Node
	
	public void displayNode(){
		System.out.println("{ "+ data + " } ");
	}
}