package com.revature.doublyLinkedList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList theList = new DoublyLinkedList();
		theList.inserFirst(1);
		theList.inserFirst(13);
		theList.inserFirst(43);
		theList.inserFirst(33);
		
		theList.displayForward();
	
		System.out.println("=====================");
		
		DoublyLinkedList theListInsertLat = new DoublyLinkedList();
		
		theListInsertLat.insertLast(1);
		theListInsertLat.insertLast(13);
		theListInsertLat.insertLast(43);
		theListInsertLat.insertLast(33);
		
		theList.displayForward();
		
	}

}
