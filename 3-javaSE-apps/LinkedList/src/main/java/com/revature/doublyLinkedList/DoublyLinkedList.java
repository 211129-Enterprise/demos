package com.revature.doublyLinkedList;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		//instantiate new node
		Node newNode = new Node();
		
		//set data to what's passed through
		 newNode.data = data;
		
		//if empty the last node points to the new node
		if (isEmpty()) {
			last = newNode;
		} else {
			first.before = newNode;
		}
		newNode.after = first;
		this.first = newNode;
		//otherwise grab the first node and set its previos pointer to the new node
	}
	
	public void insertLast (int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			first = newNode;
		} else {
			last.after = newNode;
			newNode.before = last;
		}
		
		last = newNode;
	}
	
	public void displayForward() {
		System.out.println("List (last --> first)");
		Node current = last;
		while (current != null) {
			current.displayNode();
			current = current.before;
		}
	
	System.out.println();
	}
	
	public Node deleteKey(int key) {
		Node current = first;//Start at the first position
		
		while (current.data != key) {//So long as the data does not match the key
			current = current.after;//Then move to the next position
		}
		
		if (current == null) {//If the position is null return null, will happen when there is no key match
			return null;
		}
		
		if (current == first) {//If the current position is the first one
			first = current.after;//The position after becomes the first
		} else { //Otherwise
			current.before.after = current.after;//The posi
		}
		
		if (current == last) {
			last = current.before;
		} else {
			current.after.before = current.before;
		}
		
		return current;
	}

}
