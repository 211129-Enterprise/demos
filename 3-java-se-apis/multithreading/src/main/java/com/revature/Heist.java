package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {
	
	// ASCENDING HackerThread is going to guess all the numbers from 0 to max.
	// DESCENDING HackerThread is going to guess all the numbers from max to 0.
	public static final int MAX_PASSWORD = 9999; // Exclusive so '9999' will NOT be guessed.

	
	
	
	
	public static void main(String[] args) {
	
		// Generate a password between
		// 0 to 9999
		Random rand = new Random();
		int password = rand.nextInt(MAX_PASSWORD);
		
		// Instantiate a vault for the "Heist"
		Vault vault = new Vault(password);
		System.out.println("The secret password is " + password);
		
		// Make a list of threads
		List<Thread> threads = new ArrayList<Thread>(); // Can add a thread of any objects of a class that extend thread
		threads.add( new DescendingHackerThread(vault) );
		threads.add( new AscendingHackerThread(vault) );
		threads.add( new PolicemanThread() );
		
		// Call the forEach method and call .start() on each thread
		threads.forEach( t -> t.start() ); // Lambda is an implementation of the accept method within the Consumer interface
											// forEach can only be called on iterable data structures
		
		
	}
	
	
	
	
	
	// Vault -> this represents the resource that all the threads are accessing
	private static class Vault{ // Nested inner class -> static, so it can only be instantiated in the main() 
								// or any method of the Heist.java class
		private int password;
		
		public Vault(int password) {
			this.password = password;
		}
		
		// The hacker threads will constantly call a method on the vault
		public boolean isCorrectPassword(int guess) {
			
			try { // Prevent program from ending too quickly
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return this.password == guess; // True or false?
			
		}
		
	}
	
	
	
	
	
	// HACKER THREAD template
	// Abstract class called HackerThread -> extends Thread
	// Providing MANDATORY set of instructions that child classes
	// have to fulfill.
	private static abstract class HackerThread extends Thread{
		
		protected Vault vault; // Making sure you can access variable from any of child classes in same package.
		
		// When we instantiate a descending or ascending HackerThread,
		// we want to pass in the vault they're working on,
		// set the name of the thread,
		// and set a priority (MAX).
		public HackerThread(Vault vault) {
			
			this.vault = vault;
			this.setName( this.getClass().getSimpleName() );
			this.setPriority(Thread.MAX_PRIORITY);
			
		}
		
		// When all child classes start() methods run,
		// this is what happens.
		@Override
		public void start() {
			// Adding a little more information / behavior
			System.out.println("Starting thread: " + this.getName());
			
			// Invoke what is already in the start class
			super.start();
			
			
			
		}
		
	}
	
	
	
	
	
	// HACKER THREAD #1 - Descending
	// static class called Descending Hacker Thread extends HackerThread
	public static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			
			// The descending hacker thread will iterate from MAX_PASSWORD to 0
			// and check if the vault's isCorrectPassword method returns true.
			for(int guess = MAX_PASSWORD; guess >= 0; guess--) { // GUESS: 9999 - 0
				
				if(vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed '" + guess + "' which is the correct password.");
					System.exit(0);
				}
				
			}
			
		}
		
	}
	
	
	
	
	// HACKER THREAD #1 - Ascending
	// static class called Ascending Hacker THread extends HackerThread
	public static class AscendingHackerThread extends HackerThread {


		
		public AscendingHackerThread(Vault vault) {
			super(vault);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			
			// The ascending hacker thread will iterate from 0 to MAX_PASSWORD
			// and check if the vault's isCorrectPassword method returns true.
			// Also, it has an edge over Descending as the max password, 9999,
			// is never used by random so all of ascending's guesses will be
			// inclusive. In other words, All of Ascending's guesses are inclusive
			// while Descending will make its first guess out of range.
			for(int guess = 0; guess < MAX_PASSWORD; guess++) { // GUESS: 0 - 998
				
				if(vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed '" + guess + "' which is the correct password.");
					System.exit(0);
				}
				
			}
			
		}
		
	}
	
	
	
	
	// POLICE THREAD
	// Policeman Thread -> extends Thread
	public static class PolicemanThread extends Thread {
		
		@Override // Overriding the run() method of the Thread class instead of implementing the runnable interface
		public void run() {
			
			int countTime = 10;
			
			// Open a for loop from 10 - 0
			for( int i = countTime; i > 0; i -- ) {
				// Make the thread sleep for one point five second between each number
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// print out how many seconds are left after each iteration
				System.out.println(i + " second(s) left.");
			}
			// if we exit the for-loop, say something like "Game over hackers!!!"
			System.out.println("Policeman999: \"G4M3  0V312  H4><><0122!!!one\"");
			
			// System.exit(0); - Cut the program... using 0 to say it ended without any problems.
			System.exit(0);
		}
	}

}
