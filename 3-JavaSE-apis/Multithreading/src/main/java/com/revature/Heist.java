package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {

	public static final int MAX_PASSWORD = 9999;
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int password = random.nextInt(MAX_PASSWORD);
		
		Vault vault = new Vault(password);
		
		System.out.println("the secret password is " + password);
		
		List<Thread> threads = new ArrayList<Thread>();
		
		threads.add(new DescendingHackerThread(vault));
		threads.add(new AscendingHackerThread(vault));
		
		threads.add(new PolicemanThread());
		
		threads.forEach(t -> t.start());

	}
	
	private static class Vault {
		private int password;

		public Vault(int password) {
			super();
			this.password = password;
		}
		
		public boolean isCorrectPassword(int guess) {
			try {
				Thread.sleep(5);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			return this.password == guess;
		}
		

		
	
	}
	
	private static abstract class HackerThread extends Thread {
		protected Vault vault;
		
		// when we instantiate a {Desc or Asc} HackerThread
		
		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
			
		}
		
		@Override 
		public void start() {
			System.out.println("Starting Thread: " + this.getName());
			super.start();
		}
	}
	
	private static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
			
		}
		
		@Override 
		public void run() {
			for (int guess = MAX_PASSWORD - 1; guess >= 0; guess--) {
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password" + guess);
					System.exit(0);
				}
			}
		}
		
	}
	
	private static class AscendingHackerThread extends HackerThread {
		public AscendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for (int guess = 0; guess < MAX_PASSWORD; guess++) {
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guess the password" + guess);
					System.exit(0);
				}
			}
		}
	}
	
	private static class PolicemanThread extends Thread {
		@Override
		public void run() {
			for (int i = 15; i > 0; i--) {
				try {
				Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i + " seconds left");
			}
			System.out.println("Game over for you hackers!");
			
			System.exit(0);
		}
	}
	


}
