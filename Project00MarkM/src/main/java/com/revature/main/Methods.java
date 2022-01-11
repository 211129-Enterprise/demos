package com.revature.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.revature.accounts.Checking;
import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;
import com.revature.classes.Person;

import com.revature.service.AccountService;
import com.revature.service.UserService;

public class Methods {
	private static final Checking Checking = null;
	private static final com.revature.accounts.Checking Savings = null;
	Scanner scan = new Scanner(System.in);
	Person person = new Customers();
	AccountService aserv = new AccountService();
	Person employee = new Employee();
	Person administrator = new Administrator();
	protected Employee newAccount;
	public int accountRanking;
	boolean notNumber = true;
	UserService userv = new UserService();

	public Employee newAccount(String firstName, String middleInitial, String lastName, String birthDate,
			String creditCheck, String socialSecurity, String userName, String passWord, int accountRanking) {
		String firstName1 = "";
		System.out.println("What is your first name?");
		firstName1 = scan.nextLine().toUpperCase();
		String middleInitial1 = "";
		System.out.println("What is your middle initial?");
		middleInitial1 = scan.nextLine().toUpperCase();
		String lastName1 = "";
		System.out.println("What is your last name?");
		lastName1 = scan.nextLine().toUpperCase();
		int accountRanking1;
		accountRanking1 = accountRanking();
		System.out.println("Your security clearance is " + accountRanking1);
		String socialSecurity1 = "";
		socialSecurity1 = socialSecurity();
		int creditCheck1 = 0;
		System.out.println("Your credit number will be conducted.");
		creditCheck1 = creditCheck();
		String userName1 = "";
		System.out.println("Please create a unique user name with letters and numbers.");
		userName1 = scan.nextLine();
		userName1 = scan.nextLine();
		String passWord1 = "";
		System.out.println("Please create a password.");
		passWord1 = scan.nextLine();
		System.out.println("Is this information correct?");
		String redo = "";
		redo = scan.nextLine();
		switch (redo.toUpperCase()) {
		case "YES":
			break;
		case "NO":
			return newAccount(redo, redo, redo, redo, redo, redo, redo, redo, accountRanking1);
		default:
			System.out.println("Please only put YES or NO.");
		}

		Employee e = new Employee();
		e.setAccountRanking(accountRanking1);
		e.setCreditCheck(creditCheck1);
		e.setFirstName(firstName1);
		e.setMiddleInitial(middleInitial1);
		e.setLastName(lastName1);
		e.setUserName(userName1);
		e.setPassWord(passWord1);
		e.setSocialSecurity(socialSecurity1);

		return e;
	}

	private int accountRanking() {
		int rank = 0;
		System.out.println("Are you currently an employee with an employee number?" + "\n" + "1 = YES" + "\n" + "2 = NO");
		int answer;

		answer = scan.nextInt();
		switch (answer) {
		case 1:
			String s;
			boolean notNumber = true;
			try {
				System.out.println("What's your employee Id number? (Should only be 8 digits)");
				s = scan.next();
				System.out.println("Verifying employee Id and rank......");
				if (s.length() == 8 && s.matches("^-?\\d+$")) {
					int employeeId = Integer.parseInt(s);
					if (employeeId >= 70000000) {
						Administrator admin = new Administrator();
						return admin.getaccountRanking();
					} else {
						Employee empl = new Employee();
						return empl.getaccountRanking();
					}
				} else {
					System.out.println("Please only put 8 numbers.");
					return accountRanking();
				}
			} catch (InputMismatchException e) {
				System.out.println("Please put only 8 numbers.");
				return accountRanking();
			}
		case 2:
			Customers cust = new Customers();
			return cust.getaccountRanking();
		default:
			System.out.println("Please only 1 or 2.");
			return accountRanking();
		}
	}

	// CreditCheck Generator
	// =======================================================================
	protected int creditCheck() {
		int min = 300;
		int max = 850;
		int c = (int) (Math.random() * (max - min + 1) + min);
		person.setCreditCheck(c);
		System.out
				.println("Your credit check came back! It looks like our soft check came back with a " + c + " score.");
		return c;
	}

	// Social Security Check
	// =======================================================================
	protected String socialSecurity() {
		System.out.println("What is your Social Security Number? Please do not use dashes.");
		String s;
		s = scan.next();
		try {
			if (s.length() == 9 && s.matches("^-?\\d+$")) { // google regex to ensure a string is an int
			} else {
				System.out.println("Please only put 9 numbers.");
				return socialSecurity();
			}
		} catch (InputMismatchException e) {
			System.out.println("Please put only 9 numbers.");
			return socialSecurity();
		}
		person.setSocialSecurity(s);
		return s;
	}

	// Customers Login Interface
	// ======================================================================
	public Customers customerLogin(Customers c) {
		boolean again = true;
		System.out.println(
				"******************************************CUSTOMER LOGIN MENU******************************************************"
						+ "\n" + "Please select from the following options." + "\n" + "1. View your accounts." + "\n"
						+ "2. Deposit money into your accounts." + "\n" + "3. Withdraw money from your accounts." + "\n"
						+ "4. Transfer funds between your Checking and Savings account." + "\n"
						+ "5. Open a new Checking " + "or Savings account." + "\n" + "6. End Program.");
		int options = 0;
		options = scan.nextInt();
		while (again) {
			again = false;
			switch (options) {
			case 1:
				viewMyAccounts(c);
				customerLogin(c);
			case 2:
				depositAccounts(c);
				customerLogin(c);
			case 3:
				withdrawAccounts(c);
				customerLogin(c);
			case 4:
				transferFunds(c);
				customerLogin(c);
			case 5:
				openNew(c);
				customerLogin(c);
			case 6:
				System.exit(6);
				break;
			default:
				System.out.println(
						"===================================Please only use the 1-6 options.============================================");
				again = true;
			}
		}
		return null;
	}

	// Customer view accounts
	// ==============================================================================================
	private void viewMyAccounts(Customers c) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"****************************************ACCOUNT VIEW MENU***********************************************************"
							+ "\n" + "Would you like to view your accounts?" + "\n" + "1. View your accounts" + "\n"
							+ "2. Return to previous menu.");
			int id = 0;
			id = scan.nextInt();
			switch (id) {
			case 1:
				System.out.println("Whats the social security of the accounts you want to look up?");
				String socialSecurity = scan.next();
				List<Checking> check = dao.findByOwner(socialSecurity);
				check.forEach(u -> System.out.println(u));
				viewMyAccounts(c);
			case 2:
				customerLogin(c);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Customer Deposit Accounts
	// =============================================================================================
	private void depositAccounts(Customers c) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"*****************************************DEPOSIT MENU***************************************************************"
							+ "\n" + "Would you like to deposit into your account?" + "\n" + "1. Make a deposit." + "\n"
							+ "2. Return to previous menu.");
			int depo = 0;
			depo = scan.nextInt();
			switch (depo) {
			case 1:
				System.out.println("How much would you like to DEPOSIT?");
				double deposit = scan.nextDouble();
				System.out.println("What's the id number you want to make the deposit into?");
				int number = scan.nextInt();
				dao.deposit(number, deposit);
				depositAccounts(c);
			case 2:
				viewMyAccounts(c);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Customer WITHDRAW Accounts
	// =============================================================================================
	private void withdrawAccounts(Customers c) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"***************************************WITHDRAW MENU****************************************************************"
							+ "\n" + "Would you like to withdraw?" + "\n" + "1. Accounts " + "\n"
							+ "2. Return to previous menu.");
			int withdraw = 0;
			withdraw = scan.nextInt();
			switch (withdraw) {
			case 1:
				System.out.println("How much would you like to WITHDRAW?");
				double withdraw1 = scan.nextDouble();
				System.out.println("What's the id number you want to make the deposit into?");
				int number = scan.nextInt();
				dao.withdraw(number, withdraw1);
				withdrawAccounts(c);
			case 2:
				viewMyAccounts(c);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Customer TRANSFER Accounts
	// =============================================================================================
	private void transferFunds(Customers c) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"*******************************************TRANSFER FUNDS***********************************************************"
							+ "\n" + "Would you like to do an account transfers?" + "\n"
							+ "1. Checking to Savings or Savings to Checking?" + "\n" + "2. Return to previous menu.");
			int transfer = 0;
			transfer = scan.nextInt();
			switch (transfer) {
			case 1:
				System.out.println("How much would you like to TRANSFER?");
				double transfer1 = scan.nextDouble();
				System.out.println("What's the id number of the FIRST account you want to WITHDRAW from?");
				int number1 = scan.nextInt();
				System.out.println("What's the id number of the SECOND account you want to DEPOSIT into?");
				int number2 = scan.nextInt();
				dao.transfer(number1, number2, transfer1);
				transferFunds(c);
			case 2:
				customerLogin(c);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Customer Open Accounts
	// =======================================================================================================
	private void openNew(Customers c) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"*******************************************NEW ACCOUNTS*************************************************************"
							+ "\n" + "Would you like to open a new account?" + "\n" + "1. Yes" + "\n" + "2. No.");
			int open = 0;
			open = scan.nextInt();
			switch (open) {
			case 1:
				aserv.openAccount(c);
				openNew(c);
			case 2:
				customerLogin(c);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// EMPLOYEES OPTIONS FOR ACCOUNTS
	// =================================================================================================
	// Employee Login Interface
	// =======================================================================================================
	public Employee employeeLogin(Employee e) {
		boolean again = true;
		System.out.println(
				"******************************************EMPLOYEE LOGIN************************************************************"
						+ "\n" + "Please select from the following options." + "\n" + "1. View your accounts." + "\n"
						+ "2. Deposit money into your accounts." + "\n" + "3. Withdraw money from your accounts." + "\n"
						+ "4. Transfer funds between your Checking and Savings account." + "\n"
						+ "5. Open a new Checking " + "or Savings account." + "\n" + "6. Approve new accounts." + "\n"
						+ "7. End Program.");
		int options = 0;
		options = scan.nextInt();
		while (again) {
			again = false;
			switch (options) {
			case 1:
				viewMyAccounts2(e);
				employeeLogin(e);
			case 2:
				depositAccounts2(e);
				employeeLogin(e);
			case 3:
				withdrawAccounts2(e);
				employeeLogin(e);
			case 4:
				transferFunds2(e);
				employeeLogin(e);
			case 5:
				openNew2(e);
				employeeLogin(e);
			case 6:
				approveNew2(e);
				employeeLogin(e);
			case 7:
				System.exit(7);
				break;
			default:
				System.out.println(
						"********************************************************************************************************************"
								+ "\n"
								+ "===================================Please only use the 1-7 options.============================================");
				again = true;
			}
		}
		return null;
	}

	// Employee view accounts
	// ==============================================================================================
	private void viewMyAccounts2(Employee e) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"*******************************************ACCOUNT VIEW MENU********************************************************"
							+ "\n" + "Would you like to view your accounts?" + "\n" + "1. View your accounts." + "\n"
							+ "2. Return to previous menu.");
			int id = 0;
			id = scan.nextInt();
			switch (id) {
			case 1:
				System.out.println("Whats the social security number of the accounts you want to look up?");
				String socialSecurity = scan.next();
				List<Checking> check = dao.findByOwner(socialSecurity);
				check.forEach(u -> System.out.println(u));
				viewMyAccounts2(e);
			case 2:
				employeeLogin(e);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Employee Deposit Accounts
	// =============================================================================================
	private void depositAccounts2(Employee e) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"**********************************************DEPOSIT MENU**********************************************************"
							+ "\n" + "Would you like to make a deposit?" + "\n" + "1. Deposit into accounts." + "\n"
							+ "2. Return to previous menu.");
			int deposit = 0;
			deposit = scan.nextInt();
			switch (deposit) {
			case 1:
				System.out.println("How much would you like to DEPOSIT?");
				double deposit1 = scan.nextDouble();
				System.out.println("What's the id number you want to make the deposit into?");
				int number = scan.nextInt();
				dao.deposit(number, deposit1);
				depositAccounts2(e);
			case 2:
				employeeLogin(e);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Employee WITHDRAW Accounts
	// =============================================================================================
	private void withdrawAccounts2(Employee e) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"********************************************WITHDRAW MENU***********************************************************"
							+ "\n" + "Would you like to withdraw from one of your accounts?" + "\n"
							+ "1. Make a withdrawl." + "\n" + "2. Return to previous menu.");
			int withdraw = 0;
			withdraw = scan.nextInt();
			switch (withdraw) {
			case 1:
				System.out.println("How much would you like to WITHDRAW?");
				int withdraw1 = scan.nextInt();
				System.out.println("What's the id number you want to make the deposit into?");
				int number = scan.nextInt();
				dao.withdraw(withdraw1, number);
				withdrawAccounts2(e);
			case 2:
				employeeLogin(e);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Employee TRANSFER Accounts
	// =============================================================================================
	private void transferFunds2(Employee e) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"**********************************************TRANSFER MENU*********************************************************"
							+ "\n" + "Would you like to do an account transfers?" + "\n"
							+ "1. Checking to Savings or Savings to Checking?" + "\n" + "2. Return to previous menu.");
			int withdraw = 0;
			withdraw = scan.nextInt();
			switch (withdraw) {
			case 1:
				System.out.println("How much would you like to TRANSFER?");
				int transfer1 = scan.nextInt();
				System.out.println("What's the id number of the FIRST account you want to WITHDRAW from?");
				int number1 = scan.nextInt();
				System.out.println("What's the id number of the SECOND account you want to DEPOSIT into?");
				int number2 = scan.nextInt();
				dao.transfer(transfer1, number1, number2);
				transferFunds2(e);
			case 2:
				employeeLogin(e);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// Employee Open Accounts
	// =======================================================================================================
	private void openNew2(Employee e) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"****************************************OPEN NEW ACCOUNT************************************************************"
							+ "\n" + "Would you like to open a new account?" + "\n" + "1. Yes." + "\n" + "2. No.");
			int open = 0;
			open = scan.nextInt();
			switch (open) {
			case 1:
				aserv.openAccount2(e);
				openNew2(e);
			case 2:
				employeeLogin(e);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// EMPLOYEES BOOLEAN APPROVAL OF NEW ACCOUNTS
	// ==========================================================================
	private void approveNew2(Employee e) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"**********************************************ACCOUNT APPROVALS****************************************************"
							+ "\n" + "1. Check on the accounts that need approval." + "\n"
							+ "2. Approve accounts by ID." + "\n" + "3. Deny accounts by ID." + "\n"
							+ "4. Return to the previous menu.");
			int approve = 0;
			approve = scan.nextInt();
			switch (approve) {
			case 1:
				userv.listEmployeeAllAccounts(e);
				approveNew2(e);
			case 2:
				System.out.println("What's the ID of the account you want to APPROVE?");
				int i = scan.nextInt();
				dao.approve(i);
				approveNew2(e);
			case 3:
				System.out.println("What's the ID of the account you want to DENY?");
				int x = scan.nextInt();
				dao.deny(x);
				approveNew2(e);
			case 4:
				employeeLogin(e);
			default:
				System.out.println(
						"===================================Please only use the 1-4 options.============================================");
				again = true;
			}
		}

	}

	// ADMINISTRATORS OPTIONS FOR ACCOUNTS
	// =================================================================================================
	// ADMINISTRATORS Login Interface
	// =======================================================================================================
	public Administrator administratorLogin(Administrator a) {
		boolean again = true;
		System.out.println(
				"************************************ADMINISTRATOR MODE************************************************************"
						+ "\n" + "Please select from the following options." + "\n" + "1. View an account." + "\n"
						+ "2. Deposit money into an account." + "\n" + "3. Withdraw money from an account." + "\n"
						+ "4. Transfer funds between your Checking and Savings account." + "\n"
						+ "5. Open a new Checking " + "or Savings account." + "\n" + "6. Approve or Deny Accounts."
						+ "\n" + "7. Cancel accounts." + "\n" + "8. End Program.");
		int options = 0;
		options = scan.nextInt();
		while (again) {
			again = false;
			switch (options) {
			case 1:
				viewMyAccounts3(a);
			case 2:
				depositAccounts3(a);
			case 3:
				withdrawAccounts3(a);
			case 4:
				transferFunds3(a);
			case 5:
				openNew3(a);
				administratorLogin(a);
			case 6:
				approveNew3(a);
			case 7:
				cancelAccounts3(a);
			case 8:
				System.exit(8);
				break;
			default:
				System.out.println(
						"===================================Please only use the 1-8 options.============================================");
				again = true;
			}
		}
		return null;
	}

	// ADMINISTRATORS view accounts
	// ==============================================================================================
	private void viewMyAccounts3(Administrator a) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"********************************************ACCOUNT VIEW MENU*******************************************************"
							+ "\n" + "Which account would you like to view?" + "\n" + "1. Checking" + "\n"
							+ "2. Return to previous menu.");
			int monies = 0;
			monies = scan.nextInt();
			switch (monies) {
			case 1:
				System.out.println("Whats the social security of the accounts you want to look up?");
				String socialSecurity = scan.next();
				List<Checking> check = dao.findByOwner(socialSecurity);
				check.forEach(u -> System.out.println(u));
				viewMyAccounts3(a);
			case 2:
				administratorLogin(a);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// ADMINISTRATORS Deposit Accounts
	// =============================================================================================
	private void depositAccounts3(Administrator a) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"*******************************************DEPOSIT MENU*************************************************************"
							+ "\n" + "Which account would you like to deposit into?" + "\n" + "1. Checking" + "\n"
							+ "2. Return to previous menu.");
			int deposit = 0;
			deposit = scan.nextInt();
			switch (deposit) {
			case 1:
				System.out.println("How much would you like to DEPOSIT?");
				double deposit1 = scan.nextDouble();
				System.out.println("What's the id number you want to make the deposit into?");
				int number = scan.nextInt();
				dao.deposit(number, deposit1);
				depositAccounts3(a);
			case 2:
				administratorLogin(a);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// ADMINISTRATORS WITHDRAW Accounts
	// =============================================================================================
	private void withdrawAccounts3(Administrator a) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"*******************************************WITHDRAW MENU************************************************************"
							+ "\n" + "Would you like to make a withdrawl?" + "\n" + "1. Withdraw from an account."
							+ "\n" + "2. Return to previous menu.");
			int withdraw = 0;
			withdraw = scan.nextInt();
			switch (withdraw) {
			case 1:
				System.out.println("How much would you like to WITHDRAW?");
				double withdraw1 = scan.nextDouble();
				System.out.println("What's the id number you want to make the deposit into?");
				int number = scan.nextInt();
				dao.withdraw(number, withdraw1);
				withdrawAccounts3(a);
			case 2:
				administratorLogin(a);
			default:
				System.out.println(
						"===================================Please only use the 1-2 options.============================================");
				again = true;
			}
		}
	}

	// ADMINISTRATORS TRANSFER Accounts
	// =============================================================================================
	private void transferFunds3(Administrator a) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"******************************************TRANSFER MENU*************************************************************"
							+ "\n" + " Which account would you like to transfer from and to?" + "\n"
							+ "1. Checking to Savings?" + "\n" + "2. Return to previous menu.");
			int withdraw = 0;
			withdraw = scan.nextInt();
			switch (withdraw) {
			case 1:
				System.out.println(" How much would you like to TRANSFER?");
				double transfer1 = scan.nextDouble();
				System.out.println(" What's the id number of the FIRST account you want to WITHDRAW from?");
				int number1 = scan.nextInt();
				System.out.println("What's the id number of the SECOND account you want to DEPOSIT into?");
				int number2 = scan.nextInt();
				dao.transfer(number1, number2, transfer1);
				transferFunds3(a);
			case 2:
				administratorLogin(a);
			default:
				System.out.println(
						"===================================Please only use the 1 and 2 options.============================================");
				again = true;
			}
		}
	}

	// ADMINISTRATORS Open Accounts
	// =======================================================================================================
	private void openNew3(Administrator a) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"**************************************NEW ACCOUNT MENU**************************************************************"
							+ "\n" + "Would you like to open a new account?" + "\n" + "1. Open a new account." + "\n"
							+ "2. Return to previous menu.");
			int open = 0;
			open = scan.nextInt();
			switch (open) {
			case 1:
				aserv.openAccount3(a);
				openNew3(a);
			case 2:
				administratorLogin(a);
				break;
			default:
				System.out.println(
						"===================================Please only use the 1 and 2 options.============================================");
				again = true;
			}
		}
	}

	// ADMINISTRATORS BOOLEAN APPROVAL OF NEW ACCOUNTS
	// ===========================================================================================================
	private void approveNew3(Administrator a) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"***************************************APPROVE MENU*****************************************************************"
							+ "\n" + "1. Check on the accounts that need approval." + "\n"
							+ "2. Approve accounts by ID." + "\n" + "3. Return to the previous menu.");
			int approve = 0;
			approve = scan.nextInt();
			switch (approve) {
			case 1:
				userv.listAdministratorAllAccounts(a);
				approveNew3(a);
			case 2:
				System.out.println("What's the ID of the account you want to APPROVE?");
				int i = scan.nextInt();
				dao.approve(i);
				approveNew3(a);
			case 3:
				administratorLogin(a);
			default:
				System.out.println(
						"===================================Please only use the 1-3 options.============================================");
				again = true;
			}
		}

	}

	// ADMINISTRATORS CANCEL ACCOUNTS
	// ===============================================================================================
	private void cancelAccounts3(Administrator a) {
		boolean again = true;
		while (again) {
			again = false;
			System.out.println(
					"*************************************CANCEL MENU*************************************************************"
							+ "\n" + "1. Press 1 to find a list of all accounts." + "\n" + "2. Deny accounts by ID."
							+ "\n" + "3. Return to the main menu.");
			int approve = 0;
			approve = scan.nextInt();
			switch (approve) {
			case 1:
				dao.findAll();
				cancelAccounts3(a);
			case 2:
				System.out.println("What's the ID of the account you want to DENY?");
				int x = scan.nextInt();
				dao.deny(x);
				cancelAccounts3(a);
			case 3:
				administratorLogin(a);
			default:
				System.out.println(
						"===================================Please only use the 1-3 options.============================================");
				again = true;
			}
		}
	}

}
