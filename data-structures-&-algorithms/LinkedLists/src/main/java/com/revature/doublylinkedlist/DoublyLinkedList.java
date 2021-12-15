package com.revature.doublylinkedlist;

/**
 * A doubly linked list is a linear data structure similar to a singly linked
 * list but here each node has an extra pointer that stores the address of the
 * previous node corresponding to each node.
 * 
 * Advantages:
 * 	- Allows us to iterate in both directions.
 * 	- We can delete a node easily as we have access to its previous node.
 * 	- Reversing is easy.
 * 
 * Disadvantages:
 * 	- Compared to a singly linked list, each node store an extra pointer 
 * 	  which consumes extra memory.
 * 	- Operations require more time due to the overhead of handling extra
 *    pointers as compared to singly-linked lists.
 *    
 * Uses:
 * 	- It can be used to implement various other data structures like hash-tables, 
 *    stacks, binary trees etc.
 * 	- Can be used to implement functionalities such as undo/redo.
 * 	- Can be used in any software which requires forward and backward navigation e.g. music players, 
 *    in web-browsers to move between previously visited and current page etc.
 * 	- Used by a thread scheduler in many operating systems to maintain a list 
 *    of all running processes.
 * 	- Can also be used in games e.g. representing a deck of cards. 
 */
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

	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			last = newNode; // if empty, last will refer to the new Node being created
		} else {
			first.previous = newNode;
		}

		newNode.next = first; // the new node's next field will point to the old first
		this.first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode; // assigning old last to newnode
			newNode.previous = last; // the old last will be the newnodes previous
		}

		last = newNode; // the linkedList's last field should point to the new node
	}


	public Node deleteKey(int key) {
		Node current = first; // start from the beginning
		while (current.data != key) {
			current = current.next;
			if (current == null) {
				return null;
			}
		}

		if (current == first) {
			first = current.next; // make the first field point to the node following current since current will
									// be deleted
		} else {
			current.previous.next = current.next;
		}

		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}

		return current;

	}

	public void displayForward() {
		System.out.print("List (first --> last): ");
		Node current = first; // start from the beginning
		while (current != null) {
			current.displayNode(); // call the display method of the node
			current = current.next; // move to the next node
		}
		System.out.println();
	}

	public void displayBackward() {
		System.out.print("List (last --> first): ");
		Node current = last; // start from the end
		while (current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}

}