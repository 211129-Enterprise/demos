package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.accounts.AccountType;
import com.revature.accounts.Checking;
import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;
import com.revature.util.ConnectionUtil;

public class AccountDAO implements IAccountDAO {
	Checking checking = new Checking();
	Customers cust = new Customers();
	public static IUserDAO udao = new UserDAO();
	Scanner scan = new Scanner(System.in);
	private static Logger logger = Logger.getLogger(AccountDAO.class);

	// FINDALL
	@Override //
	public List<Checking> findAll() {
		List<Checking> accList = new LinkedList<Checking>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			Statement stmt = conn.createStatement();
			String sql = "Select * FROM bank";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				String accountNumber = rs.getString("number");
				AccountType checkingSavings = AccountType.valueOf(rs.getString("account_type"));
				boolean active = rs.getBoolean("active");
				Checking a = new Checking(id, accountNumber, balance, checkingSavings, active);
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------"
								+ "\n" + a);
				accList.add(a);
			}
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all Accounts from the DB due to SQL Exceptions.");
			e.printStackTrace();
		}
		return accList;
	}

	// CHECKING UPDATE
	// ======================================================================================================
	@Override
	public Customers insert(Checking i, Customers p) {
		String number = Number();
		for (Customers c : i.getCustomers()) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				String sql1 = "INSERT INTO bank (number, balance, account_type, active) VALUES (?, ?, ?, ?) RETURNING bank.id";
				PreparedStatement stmt1 = conn.prepareStatement(sql1);
				stmt1.setString(1, number);
				stmt1.setDouble(2, i.getBalance());
				stmt1.setObject(3, i.getAccountType(), Types.OTHER);
				stmt1.setBoolean(4, true);
				ResultSet rs;
				String sql = "INSERT INTO accounts_bank (acc_owner, account_number) VALUES (?, ?) RETURNING accounts_bank.id";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setObject(1, c.getSocialSecurity());
				stmt.setString(2, number);
				ResultSet rs1;

				if (((rs = stmt1.executeQuery()) != null) && ((rs1 = stmt.executeQuery()) != null)) {
					rs1.next();
					rs.next();
					int id = rs1.getInt(1);
					return p;
				}
				logger.info("Successfully added account number to accounts_bank " + i.getId() + ".");
			} catch (SQLException e) {
				logger.warn("This account already exists!");
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Employee insert2(Checking b, Employee f) {
		String number = Number();
		for (Employee e : b.getEmployee()) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				String sql1 = "INSERT INTO bank (number, balance, account_type, active) VALUES (?, ?, ?, ?) RETURNING bank.id";
				PreparedStatement stmt1 = conn.prepareStatement(sql1);
				stmt1.setString(1, number);
				stmt1.setDouble(2, b.getBalance());
				stmt1.setObject(3, b.getAccountType(), Types.OTHER);
				stmt1.setBoolean(4, true);
				ResultSet rs;
				String sql = "INSERT INTO accounts_bank (acc_owner, account_number) VALUES (?, ?) RETURNING accounts_bank.id";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setObject(1, e.getSocialSecurity());
				stmt.setString(2, number);
				ResultSet rs1;

				if (((rs = stmt1.executeQuery()) != null) && ((rs1 = stmt.executeQuery()) != null)) {
					rs1.next();
					rs.next();
					int id = rs1.getInt(1);
					return f;
				}
				logger.info("Successfully added account number to accounts_bank " + e.getId() + ".");
			} catch (SQLException ex) {
				logger.warn("This account already exists!");
				ex.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Administrator insert3(Checking d, Administrator l) {
		String number = Number();
		for (Administrator a : d.getAdministrator()) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				String sql1 = "INSERT INTO bank (number, balance, account_type, active) VALUES (?, ?, ?, ?) RETURNING bank.id";
				PreparedStatement stmt1 = conn.prepareStatement(sql1);
				stmt1.setString(1, number);
				stmt1.setDouble(2, d.getBalance());
				stmt1.setObject(3, d.getAccountType(), Types.OTHER);
				stmt1.setBoolean(4, true);
				ResultSet rs;
				String sql = "INSERT INTO accounts_bank (acc_owner, account_number) VALUES (?, ?) RETURNING accounts_bank.id";
				PreparedStatement stmt = conn.prepareStatement(sql);
				logger.info(a.getSocialSecurity());
				stmt.setObject(1, a.getSocialSecurity());
				stmt.setString(2, number);
				ResultSet rs1;

				if (((rs = stmt1.executeQuery()) != null) && ((rs1 = stmt.executeQuery()) != null)) {
					rs1.next();
					rs.next();
					int id = rs1.getInt(1);
					return l;
				}
				logger.info("Successfully added account number to accounts_bank " + d.getId() + ".");
			} catch (SQLException e) {
				logger.warn("This account already exists!");
				e.printStackTrace();
			}
		}
		return null;
	}

	// FIND ACCOUNTS BY ID - CHECKING AND
	// SAVINGS========================================================================
	@Override
	public Checking findById(int id) {
		List<Checking> check = new LinkedList<Checking>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT bank.id, bank.balance, bank.active, bank.number, bank.account_type, accounts_bank.acc_owner FROM \"MarkM\".bank\r\n"
					+ "INNER JOIN \"MarkM\".accounts_bank\r\n" + "ON bank.number = accounts_bank.account_number\r\n"
					+ "WHERE bank.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs1 = stmt.executeQuery();
			while (rs1.next()) {
				int returnedId = rs1.getInt("id");
				AccountType returnedAccountType = AccountType.valueOf(rs1.getString("account_type"));
				String returnedNumber = rs1.getString("number");
				Double returnedBalance = rs1.getDouble("balance");
				Boolean isActive = rs1.getBoolean("active");
				Checking a = new Checking(returnedId, returnedNumber, returnedBalance, returnedAccountType, isActive);
				if (!check.contains(a)) {
					check.add(a);
				}
				return a;
			}
		} catch (SQLException e) {
			logger.warn("Failed to retrieve all accounts owned by this person.");
			e.printStackTrace();
		}
		return null;
	}

	// FIND OWNER CHECKING ====INDIVIDUAL??=====ADD TO ARRAY
	// LIST=============================================
	@Override
	public List<Checking> findByOwner(String socialSecurity) {
		List<Checking> check = new LinkedList<Checking>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT bank.id, bank.balance, bank.active, bank.number, bank.account_type, accounts_bank.acc_owner FROM \"MarkM\".bank\r\n"
					+ "INNER JOIN \"MarkM\".accounts_bank\r\n" + "ON bank.number = accounts_bank.account_number\r\n"
					+ "WHERE accounts_bank.acc_owner = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, socialSecurity);
			ResultSet rs1 = stmt.executeQuery();
			while (rs1.next()) {
				int returnedId = rs1.getInt("id");
				AccountType returnedAccountType = AccountType.valueOf(rs1.getString("account_type"));
				String returnedNumber = rs1.getString("number");
				Double returnedBalance = rs1.getDouble("balance");
				Boolean isActive = rs1.getBoolean("active");
				Checking a = new Checking(returnedId, returnedNumber, returnedBalance, returnedAccountType, isActive);
				if (!check.contains(a)) {
					check.add(a);
				}
			}
		} catch (SQLException e) {
			logger.warn("Failed to retrieve all accounts owned by this person.");
			e.printStackTrace();
		}
		return check;
	}

	// UPDATE NEW ACCOUNT
	// APPROVE=================================================================================================
	public double update(double newBalance, int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			Customers c = new Customers();

			String sql = "UPDATE bank SET balance = ? WHERE id = ?";

			// prepare statement
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setDouble(1, newBalance);
			stmt.setInt(2, id);

			if ((stmt.executeUpdate()) >= 0) {

				return newBalance;
			}
			return 0;
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - failed to retrieve account from DB");
			e.printStackTrace();
		}
		return 0;
	}

	// DELETE USER METHOD FOR ADMINISTRATORS
	// ==================================================================================
	@Override
	public boolean delete(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM bank CASCADE\r\n WHERE accounts.id = ?";
			PreparedStatement stmt3 = conn.prepareStatement(sql);
			stmt3.setInt(1, id);

			if ((stmt3.executeQuery()) != null) {
				return true;
			}
			return false;
		} catch (SQLException s) {
			logger.warn("Customer/Employee/Administrator was not removed.");
			s.printStackTrace();
		}
		return false;
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

	// DEPOSIT FUNDS
	// =========================================================================================================
	public Checking deposit(int number, double deposit) {
		Checking checking = findById(number);
		double newBalance = checking.getBalance() + deposit;
		checking.setBalance(newBalance);
		logger.info("Previous balance of " + checking.getBalance() + " and withdraw amount of " + deposit + ".");
		if (deposit > 0) {

			checking.setBalance(newBalance);
			try {
				Connection conn = ConnectionUtil.getConnection();
				String sql1 = "UPDATE bank SET bank.balance = ? WHERE bank.id = ?";
				PreparedStatement stmt = conn.prepareStatement(sql1);
				stmt.setDouble(1, newBalance);
				stmt.setInt(2, number);
				update(newBalance, number);
				System.out.println("Your new account balance is " + newBalance + " monies.");
				logger.info("New balance is now " + newBalance + " for account" + ".");
				return checking;
			} catch (SQLException e) {
				System.out.println("OOPS! Time to restart!");
			}
		}
		return null;
	}

	// WITHDRAW
	// FUNDS=======================================================================================================
	public Checking withdraw(int number, double withdraw) {
		Checking checking = findById(number);
		double newBalance = checking.getBalance() - withdraw;
		checking.setBalance(newBalance);
		logger.info("Previous balance of " + checking.getBalance() + " and withdraw amount of " + withdraw + ".");
		if (withdraw > 0) {
			checking.setBalance(newBalance);
			try {
				Connection conn = ConnectionUtil.getConnection();
				String sql1 = "UPDATE bank SET bank.balance = ? WHERE bank.id = ?";
				PreparedStatement stmt = conn.prepareStatement(sql1);
				stmt.setDouble(1, newBalance);
				stmt.setInt(2, number);
				update(newBalance, number);
				logger.info("New balance is now " + newBalance + ".");
				return checking;
			} catch (SQLException e) {
				System.out.println("OOPS! Something happened! Restart!");
			}
		}
		return null;
	}

	// TRANSFER FUNDS
	// =========================================================================================================
	public boolean transfer(int id1, int id2, double transfer) {
		if ((withdraw(id1, transfer) != null && deposit(id2, transfer) != null)) {
			logger.info("transfer for " + transfer + " from and to account numbers " + id1 + " " + id2 + " has been completed.");
			return true;
		}
		return false;
	}

	@Override
	public boolean approve(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			Customers c = new Customers();
			String sql = "UPDATE accounts SET active = ? WHERE id = ?";
			boolean denied = false;
			boolean approved = true;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setInt(2, id);
			if ((stmt.executeUpdate()) >= 0) {
				logger.info("User " + id + " was approved.");
				return approved;
			}
			return false;
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - failed to retrieve account from DB");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deny(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			Customers c = new Customers();
			String sql = "UPDATE accounts SET active = ? WHERE id = ?";
			boolean denied = false;
			boolean approved = true;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, false);
			stmt.setInt(2, id);
			if ((stmt.executeUpdate()) >= 0) {
				logger.info("User " + id + " was denied an account.");
				return approved;
			}
			return false;
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - failed to retrieve account from DB");
			e.printStackTrace();
		}
		return false;
	}
	// END
	// CLASS===============================================================================================================

}