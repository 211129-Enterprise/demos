package com.revature.doublyLinkedList;

public class Node {
	
	public int data;
	public Node next;// singly list can oly point to the next
	public Node previous; // doubly have prvious too
	
	
	public void displayNode () {
		System.out.println("{" + data + "}");

}
	
}

