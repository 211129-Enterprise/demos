package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {
		
	public static final int MAX_PASSWORD = 10000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//generate a random pwd btw 0-9999;
		
		Random random = new Random();
		
		int password = random.nextInt(MAX_PASSWORD);
		
		Vault vault = new Vault(password );
		
		List<Thread> threads = new ArrayList<>(); // can add thread of any object that extands threads;
		
		threads.add(new DecendentHacker(vault));
		threads.add(new AccentHacker(vault));
		threads.add(new PolicemanThread());
		
		
		// lambda ---> acccept ---> comsumer 
		threads.forEach((t)-> t.start());
		
	}
	
	
	// abstract class called HackerThread -> extands Thread
	
	private static class Vault {
		
		private int passWord ;
		
		public Vault(int pwd) {
			this.passWord = pwd;
		}
		
		public boolean isCorrectPasWord(int guess) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return this.passWord == guess ;
		}
		
		
	}
	
	// static class called decending hacker thread extnds hakerThread 
	
	// static class acending hackerThread bectands HackerThread 
	
	// Policemab Thred -> extands Thrad 
	
	private static abstract class HackerThread extends Thread{
		protected Vault vault ;
		
		// when we instantiate a ( DES or ASC ) HackerThread 
		// - pass a vault to their constructor 
		//
		//'
		
		public HackerThread(Vault vault ) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
			
		}
		
		
		
	@Override 
	public void start() {	
		System.out.println("Starting Thread : " + this.getName());
		super.start();
	}
		
		
		
	}
	
	
	
private static class DecendentHacker extends HackerThread {

	public DecendentHacker(Vault vault) {
		super(vault);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void run() {
		for(int guess = MAX_PASSWORD ; guess >=0 ; guess --) {
			if(vault.isCorrectPasWord(guess)) {
				System.out.println(this.getName() + "Found in the  in decendenthacker and the guess is " + guess);
				System.exit(0);
			}
		}
	}
	
	
		
	}



private static class AccentHacker extends HackerThread {

public AccentHacker(Vault vault) {
	super(vault);
	// TODO Auto-generated constructor stub
}


@Override
public void run() {
	for(int guess = 0; guess <= MAX_PASSWORD  ; guess ++) {
		if(vault.isCorrectPasWord(guess)) {
			System.out.println(this.getName() + "Found in the  in AccentHacker and the guess is " + guess);
			System.exit(0);
		}
	}
}


	
}
	

private static class PolicemanThread extends Thread{
	
	@Override 
	public void run() {
		// open a for loop from 10-0;
		
		for(int i=15 ; i> 0 ; i--) {
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(i + "Second left ");
		}
		
		
		
		// game over ; hacker cut 
		
		System.out.println("Game over for you hackers !");
		
		
		// exit with no problem;
		System.exit(0);
		
		// system.exit(0);
	}
	
	
}
	
	
	
}
