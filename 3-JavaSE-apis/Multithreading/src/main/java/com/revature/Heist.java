package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {
	
	public static final int MAX_PASSWORD = 9999;
	
	public static void main(String[] args) {
		
		// instantiate a vault up here and generate a random password between 0 - 9999;
		Random random = new Random();
		int password = random.nextInt(MAX_PASSWORD);
		Vault vault = new Vault(password);
		System.out.println("The secret password is " + password);
		
		List<Thread> threads = new ArrayList<Thread>();
			
		threads.add(new DescendingHackerThread(vault));
		threads.add(new AscendingHackerThread(vault));
		threads.add(new PolicemanThread());
		
		// call the forEach() method and call .start() on each thread
		threads.forEach(t -> t.start()); // can only be called on Iterable Datastructures.
		
	}
	
	// Vault class represents the resource that all the threads are accessing
	private static class Vault { // nested inner class -> static, so it can only be instantiated within any method of the heist class
		
		private int password;
				
		public Vault(int password) {
			this.password = password;
		}
		
		// the hacker threads will constantly call a method on the vault
		public boolean isCorrectPassword(int guess) {
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return this.password == guess; // true or false?
			
		}
		
	}
	
	// Abstract class called HackerThread -> extends Thread
	private static abstract class HackerThread extends Thread {
		
		protected Vault vault;
		
		/**
		 * When we instantiate a (Desc or Asc) HackerThread
		 * - pass a vault to their constructor
		 * - set the name
		 * - set priority as MAX
		 */
		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
		}
		
		// when all child classes' .start() method is run, this is what happens:
		@Override
		public void start() {
			System.out.println("Starting Thread: " + this.getName()); // getClass() typically returns
			super.start();											  // com.revature.ThreadCreation.DescendingHackerThread
																	  // that's why we want to use simple name.
			
		}
		
	}
	// static class called DescendingHackerThread extends HackerThread
	private static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override // when its run() method is invoked, what does it do?
		public void run() {
			// the desc. hackerThread will iterate from MAX_PASSWORD to 0 and check
			for (int guess = MAX_PASSWORD - 1; guess >= 0; guess--) {
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0);
				}
			}
		}
		
	}
	
	// static class called AscendingHackerTHread extends HackerThread
	private static class AscendingHackerThread extends HackerThread {

		public AscendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			// the asc hackerthread will iterate from 0 to MAX_PASSWORD and check.
			for (int guess = 0; guess < MAX_PASSWORD; guess++) {
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0);
				}
			}
		}
		
	}
	
	// Policeman Thread extends Thread
	private static class PolicemanThread extends Thread {
		
		@Override
		public void run() {
			// open a for loop from 10 - 0 
			// make thread sleep for 1.5 second between each number
			for (int i = 15; i > 0; i--) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// print out how many seconds are left after each iteration
				System.out.println( (i - 1) + " seconds left");
			}
			// if we exit the forLoop say game over, hackers caught!
			System.out.println("Game over for you hackers!");
			// System.exit(0) - Cut the program!
			System.exit(0); // cut the program!
		}
		
	}
}
