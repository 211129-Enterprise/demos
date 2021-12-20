package com.revature.doublyLinkedList;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void inserFirst(int data) {
		
		Node newNode = new Node();
		
		newNode.data = data;
		
		if(isEmpty()) {
			last = newNode;
		}else {
			first.previous = newNode;
		}
	
		newNode.next = first;
		this.first = newNode ;
		
		
	}
	
	
	public void displayForward() {
		System.out.println("List (list --> first ): ");
		
		Node current = last;
		while(current != null) {
			current.displayNode();
			current = current.previous
		;
		
		}
	
	}
	
	
	
	
	
	public void  insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			
		first= newNode;
		}else {
			last.next = newNode;
			newNode.previous = last;
		}
		
		last = newNode;

	}
	
	
	
	public Node deleteKey(int key) {
		Node current = first ;
		
		while(current.data != key) {
			current =current.next ;
			if(current.next == null) {
				return null;
					};
			
					
			}
		
		
		if(current == first) {
			first = current.next;
		}	
		
		if(current == last) {
			last = current.previous;
		}else {
			current.next.previous = current.previous;
		}
		
		return current ;
		}
	
	
	
	
}