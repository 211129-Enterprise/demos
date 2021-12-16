package com.revature.doublylinkedlist;

public class DoublyLinkedList {
	// Every linked list has an indicator for head and tail
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
				
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		
		// instantiate a new node
		Node newNode = new Node();
		// set the data of the NOde = to what's passed thru
		newNode.data = data;
		// if empty, last node will point to new node
		if (isEmpty()) {
			last = newNode;
		} else {
			first.previous = newNode;
			newNode.next = first;
		}
		this.first = newNode;
		// otherwise we grab first node and set previous pointer to new node
	}
	
	public void insertLast(int data) {
		
		Node newNode = new Node();
		
		newNode.data = data;
		
		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}
	
	public Node deleteKey(int key) {
		
		Node current = first;
		
		while (current.data != key) {
			
			current = current.next;
			if (current == null) {
				return null;
			}
		}
		
		if (current == first) {
			first = current.next;
		} else if (current == last) {
			last = current.previous;
		}
		
		current.previous.next = current.next;
		current.next.previous = current.previous;
		
		return current;
		
	}
	
	public void displayForward() {
		System.out.println("List (last --> first): ");
		Node current = last;
		while (current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}
}
