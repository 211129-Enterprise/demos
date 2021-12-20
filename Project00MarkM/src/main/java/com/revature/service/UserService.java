package com.revature.service;

import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;
import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.main.Application;
import com.revature.util.Role;

public class UserService {
	// we will inject a DAO object into this class. So that this class can use it's
	// methods.
	// DEPENDENCY INJECTION
	private Logger logger = Logger.getLogger(UserService.class);
	public UserDAO DAO = new UserDAO();
	public static IUserDAO udao = new UserDAO();

	// REGISTER USERS
	// ============================================================================================================
	public Customers register(Customers c) {
		logger.info("Registering Customer.....");
		// maybe it checks that the User has an id of 0 BEFORE trying to register it
		if (c.getId() != 0) {
			// All User objects that HAVEN'T been persisted to the DB have an id of 0
			throw new RegisterUserFailedException(
					"User not valid to register because Id was " + c.getId() + " and not 0.");
			// let's make a custom exception called RegisterUserFailed Exception to specify
			// what went wrong...
		}
		// if the User's id IS 0.. call on the DAO to insert the object
		int generatedId = DAO.insert(c); // this returns the primary key of the inserted User

		// is the generate Pk -1? is it equal to the User's Id that was passed thru the
		// method?
		if (generatedId != -1 && generatedId != c.getId()) {
			c.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("User's Id was either -1 or did not change after insertion into DB");
		}
		logger.info("Successfully registered Customer with the id of " + c.getId());
		return c;
	}

	// REGISTER
	// EMPLOYEE==========================================================================================================
	public Employee register(Employee e) {
		logger.info("Registering Employee.....");

		// maybe it checks that the User has an id of 0 BEFORE trying to register it
		if (e.getId() != 0) {
			// All User objects that HAVEN'T been persisted to the DB have an id of 0
			throw new RegisterUserFailedException(
					"User not valid to register because Id was " + e.getId() + " and not 0.");
			// let's make a custom exception called RegisterUserFailed Exception to specify
			// what went wrong...
		}
		// if the User's id IS 0.. call on the DAO to insert the object
		int generatedId = DAO.insert(e); // this returns the primary key of the inserted User
		// is the generate Pk -1? is it equal to the User's Id that was passed thru the
		// method?
		if (generatedId != -1 && generatedId != e.getId()) {
			e.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("User's Id was either -1 or did not change after insertion into DB");
		}
		logger.info("Successfully registered Employee with the id of " + e.getId());
		return e;
	}

	// REGISTER
	// ADMINISTRATOR==========================================================================================================
	public Administrator register(Administrator a) {
		logger.info("Registering Administrator.....");

		// maybe it checks that the User has an id of 0 BEFORE trying to register it
		if (a.getId() != 0) {
			// All User objects that HAVEN'T been persisted to the DB have an id of 0
			throw new RegisterUserFailedException(
					"User not valid to register because Id was " + a.getId() + " and not 0.");
			// let's make a custom exception called RegisterUserFailed Exception to specify
			// what went wrong...
		}

		// if the User's id IS 0.. call on the DAO to insert the object
		int generatedId = DAO.insert(a); // this returns the primary key of the inserted User

		// is the generate Pk -1? is it equal to the User's Id that was passed thru the
		// method?
		if (generatedId != -1 && generatedId != a.getId()) {
			a.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("User's Id was either -1 or did not change after insertion into DB");
		}

		logger.info("Successfully registered Administrator with the id of " + a.getId());
		return a;
	}

	// Customers LOGIN
	// ========================================================================================================
	public Customers loginCustomers(String username, String password) {
		// call our dao's findByUsername() method
		Customers returnedCustomers = DAO.findCustomersByUsername(username);

		if ((!returnedCustomers.getPassWord().equals(password)) || (returnedCustomers.getRole() != Role.Customers)) {
			System.out.println("Authentication failed.");
			Application.run();
			return null;
		} 

		System.out.println("Successfully logged in!");
		return returnedCustomers;

	}

	// Employee LOGIN
	// ========================================================================================================
	public Employee loginEmployee(String username, String password) {
		// call our dao's findByUsername() method
		Employee returnedEmployee = DAO.findEmployeeByUsername(username);

		if ((!returnedEmployee.getPassWord().equals(password)) || (returnedEmployee.getRole() != Role.Employee)) {
			System.out.println("Authentication failed.");
			Application.run();
			return null; 
		
		}

		System.out.println("Successfully logged in!");
		return returnedEmployee;
	}
	// ADMINISTRATORS LOGIN
	// ========================================================================================================
	public Administrator loginAdministrator(String username, String password) {
		// call our dao's findByUsername() method
		Administrator returnedAdministrator = DAO.findAdministratorByUsername(username);

		if ((!returnedAdministrator.getPassWord().equals(password)) || (returnedAdministrator.getRole() != Role.Administrator)) {
			System.out.println("Authentication failed.");
			Application.run();
			return null;
		}

		System.out.println("Successfully logged in!");
		return returnedAdministrator;
	}

	// LIST ALL
	// LISTCUSTOMERSALLACCOUNTS=========================================================================================
	public void listEmployeeAllAccounts(Employee e) {
		try {
			List<Customers> accounts = DAO.findAll(false);

			accounts.forEach(c -> System.out.println(c + "\n"
					+ "======================================================================================================================================================================================"));
		} catch (NullPointerException n) {
			System.out.println("There are no accounts to approve at this time.");
			return;
		}
	}

	public void listAdministratorAllAccounts(Administrator a) {
		try {
			List<Customers> accounts = udao.findAll(false);
			// below we're utilizing a lambda function
			accounts.forEach(c -> System.out.println(c));
		} catch (NullPointerException n) {
			System.out.println("There are no accounts to approve at this time.");
			return;
		}
	}

	// UPDATE CUSTOMERS
	// =============================================================================================================
	public void updateCustomers(Customers c) {
		// find the user, grab user information from database, then grab the updated
		// information from customer.
		// create customer object out of this information.

		Scanner scan = new Scanner(System.in);
		System.out.println("What's the new First name?");
		c.setFirstName(scan.nextLine());
		System.out.println("What's the new Middle Initial?");
		c.setMiddleInitial(scan.nextLine());
		System.out.println("What's the new Last Name?");
		c.setLastName(scan.nextLine());
		System.out.println("What's the new password?");
		c.setPassWord(scan.nextLine());
		DAO.update(c);
	}

	// UPDATE CUSTOMERS
	// =============================================================================================================
	public void updateEmployee(Employee e) {
		// find the user, grab user information from database, then grab the updated
		// information from customer.
		// create customer object out of this information.

		Scanner scan = new Scanner(System.in);
		System.out.println("What's the new First name?");
		e.setFirstName(scan.nextLine());
		System.out.println("What's the new Middle Initial?");
		e.setMiddleInitial(scan.nextLine());
		System.out.println("What's the new Last Name?");
		e.setLastName(scan.nextLine());
		System.out.println("What's the new password?");
		e.setPassWord(scan.nextLine());
		udao.update(e);
	}

}