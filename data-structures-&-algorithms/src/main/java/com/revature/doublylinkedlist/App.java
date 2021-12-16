package com.revature.doublylinkedlist;

public class App {
	
	public static void main(String[] args) {
		
		DoublyLinkedList theList = new DoublyLinkedList();
		
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(88);
		theList.insertFirst(33);
//		theList.insertLast(22);
//		theList.insertLast(44);
//		theList.insertLast(88);
		
		
		theList.displayForward();		
		theList.deleteKey(44);
		theList.displayForward();
	}
}
