package com.revature.main;

import java.util.Scanner;

import com.revature.service.AccountService;
import com.revature.service.UserService;
import com.revature.util.Role;
import com.revature.classes.Customers;
import com.revature.classes.Employee;
import com.revature.classes.Administrator;

public class Application {
	private static Scanner scan =new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		run();
		System.gc();
		System.out.println("Thank you for being our loyal customer!");
	}
	public static void run() {
		UserService uservice = new UserService();
		Methods methods = new Methods();
		AccountService aserv = new AccountService();
	
		System.out.println("Welcome to the Bank of Revature!" + "\n" + "======================================================================================================");
		System.out.println("Are you a new account holder?" + "\n" + "1 = YES" + "\n" + "2 = NO");
		int answer = scan.nextInt();
		if (answer == 1) {
			Employee u = methods.newAccount(null, null, null, null, null, null, null, null, answer);
			
				if (u.getAccountRanking() == 1) {
					Customers c = new Customers();
					c.setId(0);
					c.setFirstName(u.getFirstName());
					c.setMiddleInitial(u.getMiddleInitial());
					c.setLastName(u.getLastName());
					c.setAccountRanking(u.getAccountRanking());
					c.setCreditCheck(u.getCreditCheck());
					c.setSocialSecurity(u.getSocialSecurity());
					c.setUserName(u.getUserName());
					c.setPassWord(u.getPassWord());
					c.setRole(Role.Customers);				
					uservice.register(c);
				} else if (u.getAccountRanking() == 2){
					Employee e = new Employee();
					e.setId(0);
					e.setFirstName(u.getFirstName());
					e.setMiddleInitial(u.getMiddleInitial());
					e.setLastName(u.getLastName());
					e.setAccountRanking(u.getAccountRanking());
					e.setCreditCheck(u.getCreditCheck());
					e.setSocialSecurity(u.getSocialSecurity());
					e.setUserName(u.getUserName());
					e.setPassWord(u.getPassWord());
					e.setRole(Role.Employee);
					uservice.register(e);
						
				}else if (u.getAccountRanking() ==3) {	
					Administrator a = new Administrator();
					a.setId(0);
					a.setFirstName(u.getFirstName());
					a.setMiddleInitial(u.getMiddleInitial());
					a.setLastName(u.getLastName());
					a.setAccountRanking(u.getAccountRanking());
					a.setCreditCheck(u.getCreditCheck());
					a.setSocialSecurity(u.getSocialSecurity());
					a.setUserName(u.getUserName());
					a.setPassWord(u.getPassWord());
					a.setRole(Role.Administrator);
					uservice.register(a);
					
				} 
			System.out.println("Once the Bank approves your account, you may log in and "
					+ "\n" + "access your account/accounts.");
			System.out.println("Thank you for choosing us!");
			
		} else if (answer == 2) {
			boolean again = true;
			String answer1;
			System.out.println("Are you a Customer or an Employee?");
			while (again) {
			again = false;	
			answer1 = scan.nextLine().toUpperCase();
			switch (answer1) {
				case "CUSTOMER":
					System.out.println("Please enter your username");
					String userName = scan.next();
					System.out.println("Please enter your password");
					String passWord = scan.next();
					// call the login method from the UserService
					Customers loggedInUser = uservice.loginCustomers(userName, passWord);
					methods.customerLogin(loggedInUser);
					break;
				case "EMPLOYEE":
					System.out.println("Please enter your username");
					String username2 = scan.next();
					System.out.println("Please enter your password");
					String password2 = scan.next();
					// call the login method from the UserService
					Employee loggedInUser2 = uservice.loginEmployee(username2, password2);
					methods.employeeLogin(loggedInUser2);
					break;
				case "ADMIN":
					System.out.println("Please enter your username");
					String username3 = scan.next();
					System.out.println("Please enter your password");
					String password3 = scan.next();
					// call the login method from the UserService
					Administrator loggedInUser3 = uservice.loginAdministrator(username3, password3);
					methods.administratorLogin(loggedInUser3);
					break;
				default: 
					System.out.println("Please put in a valid response, Customer or Employee");
					System.out.println("Are you a Customer or an Employee?");
					again = true;
					
			} }
			
			
		} 
		
	}
		
	
	
}
