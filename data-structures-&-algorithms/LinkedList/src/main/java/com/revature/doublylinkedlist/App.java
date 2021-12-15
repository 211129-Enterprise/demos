package com.revature.doublylinkedlist;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList theList = new DoublyLinkedList();
//		theList.insertFirst(22);
//		theList.insertFirst(44);
//		theList.insertFirst(66);
//		theList.insertFirst(88);
//
// OUTPUTS: 
// List (last --> first): { 22 }
//		{ 44 }
//		{ 66 }
//		{ 88 }

		
		
		
		theList.insertLast(22);
		theList.insertLast(44);
		theList.insertLast(66);
		theList.insertLast(88);
//
// OUTPUTS:
//		List (last --> first): { 88 }
//		{ 66 }
//		{ 44 }
//		{ 22 }
		
		theList.displayForward();
	}

}
