package com.revature.doublylinkedlist;

public class DoublyLinkedList {
	// Every Linked List has a Node called Tail and Head
	private Node first;
	private Node last;
	
	
	
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	
	
	
	public boolean isEmpty() {
		
		// Return whether the HEAD (first) Node is null or not
		return (first == null);
	}
	
	
	
	public void insertFirst(int data) {
		
		// Instantiate a new node
		Node newNode = new Node();
		
		// Set the data of the Node == what is passed through
		newNode.data = data;
		
		// If empty, the last Node will point to the new Node
		if(isEmpty()) {
			last = newNode; // If List is empty, the last node will refer to the new Node being created
		
		} else { // Otherwise, we grab the first Node and set its previous pointer to the new node
			first.previous = newNode;
		
		}
		
		newNode.next = first; // The new node's next field will point to the old first
		this.first = newNode;
		
	}
	
	
	
	public void insertLast(int data) {
		
		// Instantiate a new node
		Node newNode = new Node();
		newNode.data = data;
		
		// If empty, the FIRST Node will point to the new Node
		if(isEmpty()) {
			first = newNode; // If List is empty, the FIRST node will refer to the new Node being created
		
		} else { // Otherwise, we grab the LAST Node and set its previous pointer to the new node
			last.next = newNode; // Assigning the old last's pointer to the new node.
			newNode.previous = last;
		
		}
		
		last = newNode;
		
	}
	
	
	
	public void displayForward() {
		System.out.print("List (last --> first): ");
		
		// Start from end
		Node current = last;
		while(current != null) {
			current.displayNode();
			current = current.previous;
		}
		
		System.out.println("\n");
	}
	
	// In order to FIND a node, and delete it in the list, we have to iterate over the whole list
	public Node deleteKey(int key) { // Pretend that the key == data that's stored inside the node
		
		Node current = first; // Start from the beginning
		
		while(current.data != key) {
			
			// move "current node" forward
			current = current.next;
			if(current == null) {
				// We reached the end of the list, no more nodes to check, return null
				return null;
			}
		}
		
		
		// IF we find the node with the key we're looking for,
		// we continue here.
		if(current == first) {
			first = current.next; // Make the first field point to the node following current since current will be deleted
		} else {
			current.previous.next = current.next;
		}
		
		// [A -> C]
		if(current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		
		return current;
	}
}
