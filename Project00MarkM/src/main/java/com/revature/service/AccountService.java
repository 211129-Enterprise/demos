package com.revature.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.accounts.AccountType;
import com.revature.accounts.Checking;
import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;
import com.revature.dao.AccountDAO;
import com.revature.dao.IAccountDAO;

public class AccountService {
	Customers customer = new Customers();
	Employee employee = new Employee();
	Administrator administrator = new Administrator();
	// inject the AccountDAO object on which this class depends

	Scanner scan = new Scanner(System.in);

	// Open Checking Account Customers
	public Customers openAccount(Customers c) {
		boolean again = true;
		System.out.println("Is this a checking or a savings account?");
		AccountType accountType = AccountType.valueOf(scan.next());
		System.out.println(
				"how much is your first to deposit? Amount must be the minimum bank account allowance of $5.00");
		double deposit = scan.nextDouble();
		System.out.println("What's the social security number of the account owner that will be on the account?");
		String socialSecurity = scan.next();
		boolean isActive = false;
		List<Customers> customers = new LinkedList<Customers>();
		Checking a = new Checking(0, Number(), deposit, accountType, isActive);
		a.setId(c.getId());
		a.setBalance(deposit);
		a.setAccountType(accountType);
		a.setActive(isActive);
		a.getCustomers().add(c);
		Customers pk = adao.insert(a, c);

		return pk;
	}

	public Employee openAccount2(Employee e) {
		System.out.println("Is this a checking or a savings account?");
		AccountType accountType = AccountType.valueOf(scan.next());
		System.out.println(
				"how much is your first to deposit? Amount must be the minimum bank account allowance of $5.00");
		double deposit = scan.nextDouble();
		System.out.println("What's the social security number of the account owner that will be on the account?");
		String socialSecurity = scan.next();
		boolean isActive = false;
		List<Employee> employee = new LinkedList<Employee>();
		Checking a = new Checking(0, Number(), deposit, accountType, isActive);
		a.setBalance(deposit);
		a.setAccountType(accountType);
		a.setActive(isActive);
		a.getEmployee().add(e);
		Employee pk = adao.insert2(a, e);

		return pk;
	}

	public Administrator openAccount3(Administrator a) {
		System.out.println("Is this a checking or a savings account?");
		AccountType accountType = AccountType.valueOf(scan.next());
		System.out.println(
				"how much is your first to deposit? Amount must be the minimum bank account allowance of $5.00");
		double deposit = scan.nextDouble();
		System.out.println("What's the social security number of the account owner that will be on the account?");
		String socialSecurity = scan.next();
		boolean isActive = false;
		List<Administrator> administrator = new LinkedList<Administrator>();
		Checking c = new Checking(0, Number(), deposit, accountType, isActive);
		c.setNumber(Number());
		c.setBalance(deposit);
		c.setAccountType(accountType);
		c.setActive(isActive);
		c.getAdministrator().add(a);
		Administrator pk = adao.insert3(c, a);

		return pk;
	}

	// Generate Checking Number
	// ============================================================================================
	private static String Number() {
		int min = 10000000;
		int max = 99999999;
		Random r = new Random();
		int randomNumber = r.nextInt((max + 1 - min) + min);
		String str = String.valueOf(randomNumber);
		return str;
	}

}
