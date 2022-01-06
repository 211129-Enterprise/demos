package com.revature.singlylinkedlist;

public class App {
	
	public static void main(String[] args) {
		
		Node nodeA = new Node();
		nodeA.data = 4;
		
		Node nodeB = new Node();
		nodeB.data = 3;
		
		Node nodeC = new Node();
		nodeC.data = 7;
		
		Node nodeD = new Node();
		nodeD.data = 8;
		
		/**
		 * Here we have instantiated the nodes but we haven't 
		 * linked them by defining each's Node property.
		 */
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		
		System.out.println(listLengthSolution(nodeA)); // should return 4 as the number of nodes connected
		System.out.println(listLengthSolution(nodeB)); // should return 3 as the number of nodes connected
		
		// ======= Demo space for SinglyLinkedList.java =======
		SinglyLinkedList mylist = new SinglyLinkedList();
		mylist.insertFirst(100);
		mylist.insertFirst(50);
		mylist.insertFirst(99);
		mylist.insertFirst(88);
		mylist.insertLast(9999999);
		
		mylist.displayList();
		
	}
	
	/**
	 * Challenge: Can you implement the following method?
	 * 
	 * @param aNode represents the head
	 * The method will count how many nodes are included in a lis .
	 * (including the head node as one of them).
	 * 
	 * @return The # of nodes attached to the the node 
	 * passed as parameter
	 * 
	 * Hint: might want to use a while loop
	 */
	public static int listLength(Node aNode) {
		
		return 0;
	}
	
	/**
	 * Think about this as counting from the "head" of the train and
	 * counting all of the "carts" (nodes) until you reach the last
	 * one which is null.
	 */
	public static int listLengthSolution(Node aNode) {
		
		Node temp = aNode;
		int count = 0;
		
		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;
	}
	
	// After solving this challenge, create the SinglyLinkedList class
}
