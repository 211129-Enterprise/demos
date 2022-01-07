package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {

	// My Ascending HackerThread is going to guess all the numbers from 0 - the MAX
	// My Descending HackerThread is going to guess all the numbers from MAX - 0;
	public static final int MAX_PASSWORD = 9999;

	public static void main(String[] args) {

		// instantiate a vault up here - and generate a random password between 0 -
		// 9999;
		Random random = new Random();

		int password = random.nextInt(MAX_PASSWORD);

		Vault vault = new Vault(password);
		System.out.println("The secret password is " + password);
		
		
		List<Thread> threads = new ArrayList<Thread>(); // can add thread of any objects of a class that extend Thread
		
		threads.add(new DescendingHackerThread(vault));
		threads.add(new AscendingHackerThread(vault));
		threads.add(new PolicemanThread());
		
		// call the forEach() method and call .start() on each thread
		threads.forEach(t -> t.start()); // can only be called on Iterable Data strcutures
	}

	// Vault -> this represents the resource that all the threads are accessing
	private static class Vault { // nested inner class -> static, so it can only be instantitated in the main()
									// method or any method of the Heist.java class

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

	// abstract class called HackerThread -> extends Thread
	private static abstract class HackerThread extends Thread {

		protected Vault vault;

		// when we instantiate a (Desc or Asc) HackerThread
		// - pass a vault to their constructor
		// - set the name
		// - set priority as MAX
		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName()); // getClass() typically returns
															// com.revature.ThreadCreation.DescendingHackerThread
			this.setPriority(Thread.MAX_PRIORITY); // that's why I chose to return simple name.
		}

		// when all child class' .start() method is run, this is what happens:
		@Override
		public void start() {
			System.out.println("Starting Thread: " + this.getName());
			super.start();
		}

	}

	// static class called Descending Hacker Thread exztends HackerThraed
	private static class DescendingHackerThread extends HackerThread {

		// vault property is abstracted from us but we can still set it due to the
		// protected access mod

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override // when it's run() method is invoked, what does it do?
		public void run() {

			// the desc. hackerthread will iterate from MAX_PASSWORD - 0 and check if the
			// vault's iscorrectPassword() method returns true
			for (int guess = MAX_PASSWORD-1; guess >= 0; guess--) { // 9998 - 0

				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0);
				}
			}
		}

	}

	// static class called Ascending HackerThread extends HackerThread
	private static class AscendingHackerThread extends HackerThread {

		// vault property is abstracted from us but we can still set it due to the
		// protected access mod

		public AscendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override // when it's run() method is invoked, what does it do?
		public void run() {

			// the desc. hackerthread will iterate from MAX_PASSWORD - 0 and check if the
			// vault's iscorrectPassword() method returns true
			for (int guess =0; guess < MAX_PASSWORD; guess++) { // iterates through 0 - 9998

				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0);
				}
			}
		}

	}

	// Policeman Thread -> extends Thread
	private static class PolicemanThread extends Thread {
		
		@Override // overriding the run() method of the Thread class INSTEAD of implementing the Runnable interface
		public void run() {
			
			// open a for loop from 10 - 0
			for (int i = 15; i > 0; i--) {

				// make the thread sleep for 1.5 seconds in between each number
				try {
					Thread.sleep(1000); // 1 second 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// print out how many seconds are left after each iteration
				System.out.println(i + " seconds left");
			}

			System.out.println("Game over for you hackers!");
			
			// if we exit the for-loop say somehting like game over, hackers caught!
			System.exit(0); // -  cut the program!

		}
		
	}
	
	

	
	
	
	
}
