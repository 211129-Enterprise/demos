package com.revature;

import java.util.Random;

public class Heist {
	
	public static final int MAX_PASSWORD = 9999;

	public static void main(String[] args) {
		//instantiate a vault with a number between 0-9999
		Random rand = new Random();
		int password = rand.nextInt(MAX_PASSWORD);
		Vault vault = new Vault(password);
		
		List<Threads> threads = new ArrayList<Thread>();
		
		Thread asc = new AscendingHackerThread(vault);
		
		

	}
	
	private static class Vault {
		private int password;
		
		//vault constructor
		public Vault (int password) {
			this.password = password;
		}
		
		
		//Hackers constantly call a method on the vault
		public boolean isCorrectPassword(int guess) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return this.password == guess;
		}
	}
	
	//The abstract class HackerThread extends Thread
	
			//DescendingHackerThread extends HackerThread
			
			//AscendingHackerThread extends HackerThread
			
			//Policeman Thread -> Extends Thread
	private static abstract class HackerThread extends Thread{
		
		protected Vault vault;
		protected boolean inTheVault;
		
		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}
		
		@Override
		public void start() {
			System.out.println("Starting thread: "+this.getName());
			super.start();
		}
		
	}
	
	private class DescendingHackerThread extends HackerThread{
		public DescendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			//the desc hackerthread will iterate from MAX_PASSWORD - 0 and check if the vaults is correctpassword
			//returns true
			for (int guess = MAX_PASSWORD; guess >= 0; guess--) {
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName()+" found the password");
					System.exit(0);
				}
				
			}
					
		}
		
	}
	
	private class AscendingHackerThread extends HackerThread{
		public AscendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for (int guess = 0; guess <= MAX_PASSWORD; guess++) {
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName()+" found the password");
					System.exit(0);
				}
				
			}
					
		}
		
	}
	
	private static class PolicemanThread extends Thread{
		@Override
		public void run() {
			for (int i = 10; i > 0; i--) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(i+" seconds left.");
			}
			
			System.out.println("Game over, policeman wins.");
			System.exit(0);
		}
	}

}
