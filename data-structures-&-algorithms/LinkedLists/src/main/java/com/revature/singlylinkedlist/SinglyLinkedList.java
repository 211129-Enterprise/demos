package com.revature.singlylinkedlist;

public class SinglyLinkedList {
	
	private Node first;
	private Node last;
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	// used to insert at the beginning of the list (shifting a previously inserted first to a higher index)
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode; // We are inserting at the head, replacing
						 // the head with the new Node we're inserting
	}
	
	public Node deleteFirst(){
		Node temp = first;
		first = first.next;
		return temp; // shifting the 2nd in line to the head
	}
	
	public void displayList(){
		System.out.println("List (first --> last) ");
		
		Node current = first;
		
		while(current != null){
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 *  Note: this is NOT efficient! We have to traverse an entire list of 
	 *  nodes just to insert something at the end. Solution to this would be
	 *  a CircularLinkedList or a DoublyLinkedList.
	 */

	public void insertLast(int data){
		
		Node current = this.first;
		while(current.next != null){
			current = current.next; // we'll loop until current.next is null
		}
		
		Node newNode = new Node();
		newNode.data = data; // add the passed through data to a new Node
		current.next = newNode; // make the 2nd to last node = new Node.
	}

}
