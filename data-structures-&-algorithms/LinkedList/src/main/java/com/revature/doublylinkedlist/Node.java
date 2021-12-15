package com.revature.doublylinkedlist;

public class Node {

	public int data;
	public Node next; //Singly Linked Lists can only point to the NEXT node and not the previous
	public Node previous; //Doubly LinkedLists store the data of the previous node
	
	public void displayNode(){
		System.out.println("{ " + data + " }");
	}
}
