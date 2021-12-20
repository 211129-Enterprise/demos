package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.accounts.Checking;
import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;
import com.revature.main.Application;
import com.revature.util.ConnectionUtil;
import com.revature.util.Role;

public class UserDAO implements IUserDAO {
	Application application = new Application();
	private String passWord;
	private static Logger logger = Logger.getLogger(UserDAO.class);

	// INSERT CUSTOMERS
	// =====================================================================================================
	@Override
	public int insert(Customers c) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO accounts (first_name, middle_initial, last_name, "
				+ "account_ranking, credit_check, social_security, username, pwd, user_role) VALUES"
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING accounts.id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getFirstName());
			stmt.setString(2, c.getMiddleInitial());
			stmt.setString(3, c.getLastName());
			stmt.setInt(4, c.getAccountRanking());
			stmt.setInt(5, c.getCreditCheck());
			stmt.setString(6, c.getSocialSecurity());
			stmt.setString(7, c.getUserName());
			stmt.setString(8, c.getPassWord());
			stmt.setObject(9, c.getRole(), Types.OTHER);
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt(1);
				logger.info("returned Customers id #" + id);
				return id;
			}
		} catch (SQLException e) {
			logger.warn("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! reload please!");
		}
		logger.info("We're sorry, this customer because the username already exists. Please try again.");
		return -1;
	}

	// FIND CUSTOMERS BY ID
	// ==============================================================================================
	@Override
	public Customers findCustomersById(int id) {
		Customers c = new Customers();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {

				rs.next();
				int returnedId = rs.getInt("id");
				String returnedUsername = rs.getString("username");
				String returnedPassword = rs.getString("pwd");

				Role role = Role.valueOf(rs.getString("user_role"));
				List<Checking> accounts = new LinkedList<Checking>();

				c.setId(returnedId);
				c.setUserName(returnedUsername);
				c.setPassWord(returnedPassword);
				c.setRole(role);
			} else {
				return c;
			}
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - can't retreive user from DB");
			System.out.println("OOPS! Reload please.");
		}
		return c;
	}

	// FIND CUSTOMERS USER NAME
	// ==========================================================================================
	public Customers findCustomersByUsername(String username) {
		Customers c = new Customers();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE username = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt("id");
				String returnedFirstName = rs.getString("first_name");
				String returnedMiddleInitial = rs.getString("middle_initial");
				String returnedLastName = rs.getString("last_name");
				String returnedSocialSecurity = rs.getString("social_security");
				int returnedAccountRanking = rs.getInt("id");
				int returnedCreditCheck = rs.getInt("credit_check");
				Role role = Role.valueOf(rs.getString("user_role"));
				Boolean isActive = rs.getBoolean("active");
				String returnedUsername = rs.getString("username");
				String returnedPassword = rs.getString("pwd");

				c.setId(id);
				c.setFirstName(returnedFirstName);
				c.setMiddleInitial(returnedMiddleInitial);
				c.setLastName(returnedLastName);
				c.setAccountRanking(returnedAccountRanking);
				c.setCreditCheck(returnedCreditCheck);
				c.setSocialSecurity(returnedSocialSecurity);
				c.setActive(isActive);
				c.setUserName(returnedUsername);
				c.setPassWord(returnedPassword);
				c.setRole(role);

			}
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - can't retreive user from DB");
			System.out.println("OOPS! reload please.");
		}
		return c;
	}

	// FIND CUSTOMERS USER NAME
	// ==========================================================================================
	public Employee findEmployeeByUsername(String username) {
		Employee e = new Employee();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE username = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt("id");
				String returnedFirstName = rs.getString("first_name");
				String returnedMiddleInitial = rs.getString("middle_initial");
				String returnedLastName = rs.getString("last_name");
				String returnedSocialSecurity = rs.getString("social_security");
				int returnedAccountRanking = rs.getInt("id");
				int returnedCreditCheck = rs.getInt("credit_check");
				Role role = Role.valueOf(rs.getString("user_role"));
				Boolean isActive = rs.getBoolean("active");
				String returnedUsername = rs.getString("username");
				String returnedPassword = rs.getString("pwd");

				e.setId(id);
				e.setFirstName(returnedFirstName);
				e.setMiddleInitial(returnedMiddleInitial);
				e.setLastName(returnedLastName);
				e.setAccountRanking(returnedAccountRanking);
				e.setCreditCheck(returnedCreditCheck);
				e.setSocialSecurity(returnedSocialSecurity);
				e.setActive(isActive);
				e.setUserName(returnedUsername);
				e.setPassWord(returnedPassword);
				e.setRole(role);
			}
		} catch (SQLException ex) {
			logger.warn("SQL Exception thrown - can't retreive user from DB");
			System.out.println("OOPS. Reload please.");
		}
		return e;
	}

	// FIND CUSTOMERS USER NAME
	// ==========================================================================================
	public Administrator findAdministratorByUsername(String username) {
		Administrator a = new Administrator();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE username = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt("id");
				String returnedFirstName = rs.getString("first_name");
				String returnedMiddleInitial = rs.getString("middle_initial");
				String returnedLastName = rs.getString("last_name");
				String returnedSocialSecurity = rs.getString("social_security");
				int returnedAccountRanking = rs.getInt("id");
				int returnedCreditCheck = rs.getInt("credit_check");
				Role role = Role.valueOf(rs.getString("user_role"));
				Boolean isActive = rs.getBoolean("active");
				String returnedUsername = rs.getString("username");
				String returnedPassword = rs.getString("pwd");

				a.setId(id);
				a.setFirstName(returnedFirstName);
				a.setMiddleInitial(returnedMiddleInitial);
				a.setLastName(returnedLastName);
				a.setAccountRanking(returnedAccountRanking);
				a.setCreditCheck(returnedCreditCheck);
				a.setSocialSecurity(returnedSocialSecurity);
				a.setActive(isActive);
				a.setUserName(returnedUsername);
				a.setPassWord(returnedPassword);
				a.setRole(role);
			}
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - can't retreive user from DB");
			System.out.println("OOPS! Reload please.");
		}
		return a;
	}

	// FIND ALL CUSTOMERS
	// ======================================================================================================
	@Override
	public List<Customers> findAll(boolean b) {
		List<Customers> accList = new LinkedList<Customers>();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE accounts.active = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, b);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String returnedFirstName = rs.getString("first_name");
				String returnedMiddleInitial = rs.getString("middle_initial");
				String returnedLastName = rs.getString("last_name");
				int returnedAccountRanking = rs.getInt("account_ranking");
				int returnedCreditCheck = rs.getInt("credit_check");
				String returnedSocialSecurity = rs.getString("social_security");
				String returnedUsername = rs.getString("username");
				String returnedPassword = rs.getString("pwd");

				Role role = Role.valueOf(rs.getString("user_role"));
				boolean isActive = rs.getBoolean("active");

				Customers x = new Customers(id, returnedFirstName, returnedMiddleInitial, returnedLastName,
						returnedAccountRanking, returnedCreditCheck, returnedSocialSecurity, returnedUsername,
						returnedPassword, isActive);

				if (!accList.contains(x) && x != null) {
					accList.add(x);
					logger.info("Accounts Successfully displayed.");
				}
			}

			return accList;
		} catch (SQLException e1) {
			logger.warn("SQL Exception thrown - can't retreive user from DB");
			System.out.println("OOPS! Reload please.");
		}
		return accList;
	}

	// UPDATE CUSTOMERS
	// ===============================================================================================
	@Override
	public boolean update(Customers u) {
		Scanner scan = new Scanner(System.in);
		List<Customers> cust = new LinkedList<Customers>();

		Connection conn = ConnectionUtil.getConnection();
		System.out.println("What id number should the system approve?");
		int id = scan.nextInt();
		String sql1 = "UPDATE accounts SET first_name = ?, middle_initial = ?, last_name = ?, pwd = ?, active = ?, \r\n"
				+ "WHERE active = 'false' RETURNING accounts_id";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql1);
			stmt.setInt(1, id);
			ResultSet rs1 = stmt.executeQuery();
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getMiddleInitial());
			stmt.setString(3, u.getLastName());
			stmt.setString(4, u.getPassWord());
			stmt.setBoolean(5, u.setActive(true));
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				String username = rs.getString(1);
				logger.info("Account with username of " + u.getUserName() + " was successfully updated.");
				return true;

			}
			return false;
		} catch (SQLException e) {
			logger.error("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! Reload please.");
		}
		return true;
	}

	// DELETE CUSTOMERS
	// ==================================================================================================
	@Override
	public boolean delete(Customers u) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "DELETE FROM accounts WHERE id = ? RETURNING id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, u.getId());
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt(1);
				logger.info("This account " + u.getId() + " was successfully deactivated.");
			}
		} catch (SQLException e1) {
			logger.error("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! Reload please.");
		}
		return false;
	}

	// INSERT EMPLOYEE
	// ===(NEWEMPLOYEE)============================================================================================
	@Override
	public int insert(Employee e) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO accounts (first_name, middle_initial, last_name, "
				+ "account_ranking, credit_check, social_security, username, pwd, user_role) VALUES"
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING accounts.id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getMiddleInitial());
			stmt.setString(3, e.getLastName());
			stmt.setInt(4, e.getAccountRanking());
			stmt.setInt(5, e.getCreditCheck());
			stmt.setString(6, e.getSocialSecurity());
			stmt.setString(7, e.getUserName());
			stmt.setString(8, e.getPassWord());
			stmt.setObject(9, e.getRole(), Types.OTHER);
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt(1);
				logger.info("Successfully updated = " + e);
				return id;
			}
		} catch (SQLException e1) {
			logger.error("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! Reload please.");
		}
		System.out.println("We're sorry, this employee username already exists. Please try again.");
		return -1;
	}

	// FIND EMPLOYEE BY
	// ID==============================================================================================================
	@Override
	public Employee findEmployeeById(int id) {
		Employee e = new Employee();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int returnedId = rs.getInt("id");
				String returnedUsername = rs.getString("username");
				String returnedPassword = rs.getString("pwd");
				Role role = Role.valueOf(rs.getString("user_role"));
				List<Checking> accounts = new LinkedList<Checking>();
				e.setId(returnedId);
				e.setUserName(returnedUsername);
				e.setPassWord(returnedPassword);
				e.setRole(role);
			}
		} catch (SQLException e1) {
			logger.warn("SQL Exception thrown - can't retreive user from DB");
			System.out.println("OOPS! Reload please.");
		}
		return e;
	}

	// UPDATE EMPLOYEE
	// =============================================================================================================
	@Override
	public Employee update(Employee e) {
		Scanner scan = new Scanner(System.in);
		Connection conn = ConnectionUtil.getConnection();
		String sql1 = "UPDATE accounts SET first_name = ?, middle_initial = ?, last_name = ?, pwd = ? "
				+ "WHERE user_name = ? RETURNING accounts_id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql1);
			stmt.setString(1, e.getFirstName());
			stmt.setString(1, e.getMiddleInitial());
			stmt.setString(1, e.getLastName());
			stmt.setString(1, e.getPassWord());
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				String username = rs.getString(1);
				logger.info("Successfully updated " + username + " into the system.");
				return e;
			}
		} catch (SQLException es) {
			logger.error("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! We need to reload!");
		}
		return e;
	}

	// DELETE EMPLOYEE
	// =============================================================================================================
	@Override
	public boolean delete(Employee e) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "DELETE FROM accounts WHERE id = ? RETURNING id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, e.getId());
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt(1);
				logger.info("returned Employees id #" + id);
			}
		} catch (SQLException e1) {
			logger.error("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! We need to reload.");
		}
		System.out.println("Employee deleted.");
		return false;
	}

	// INSERT ADMINISTRATOR ==(NEW
	// USER)===========================================================================================
	@Override
	public int insert(Administrator a) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO accounts (first_name, middle_initial, last_name, "
				+ "account_ranking, credit_check, social_security, username, pwd, user_role) VALUES"
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING accounts.id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getFirstName());
			stmt.setString(2, a.getMiddleInitial());
			stmt.setString(3, a.getLastName());
			stmt.setInt(4, a.getAccountRanking());
			stmt.setInt(5, a.getCreditCheck());
			stmt.setString(6, a.getSocialSecurity());
			stmt.setString(7, a.getUserName());
			stmt.setString(8, a.getPassWord());
			stmt.setObject(9, a.getRole(), Types.OTHER);
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt(1);
				logger.info("Sucessfully updated " + a + " into the system database.");
				return id;
			}
		} catch (SQLException e2) {
			logger.error("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! We need to reload.");
		}
		System.out.println("We're sorry, this employee already exists in our files. Please try again.");
		return -1;
	}

	// FIND ADMIN BY ID
	// =================================================================================================
	@Override
	public Administrator findAdministratorById(int id) {
		Administrator a = new Administrator();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int returnedId = rs.getInt("id");
				String returnedUsername = rs.getString("username");
				String returnedPassword = rs.getString("pwd");
				Role role = Role.valueOf(rs.getString("user_role"));
				List<Checking> accounts = new LinkedList<Checking>();

				a.setId(returnedId);
				a.setUserName(returnedUsername);
				a.setPassWord(returnedPassword);
				a.setRole(role);
			} else {
				return a;
			}
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - can't retreive user from DB");
			System.out.println("OOPS! We need to reload!");
		}
		return a;
	}

	// UPDATE ADMIN
	// ================================================================================================================
	@Override
	public Administrator update(Administrator a) {
		Scanner scan = new Scanner(System.in);
		Connection conn = ConnectionUtil.getConnection();
		String sql1 = "UPDATE accounts SET first_name = ?, middle_initial = ?, last_name = ?, pwd = ? "
				+ "WHERE user_name = ? RETURNING accounts_id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql1);
			adminUpdate();
			stmt.setString(1, a.getFirstName());
			stmt.setString(1, a.getMiddleInitial());
			stmt.setString(1, a.getLastName());
			stmt.setString(1, a.getPassWord());
			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				String username = rs.getString(1);
				logger.info("Account " + username + " is successfully updated.");
				return a;
			}
		} catch (SQLException e) {
			logger.error("Unable to insert User, SQL exception thrown.");
			System.out.println("OOPS! We need to restart!");
		}
		return a;
	}

	private void adminUpdate() {
	}

	// DELETE ADMIN
	// ==================================================================================================================
	@Override
	public boolean delete(Administrator a) {
		Scanner scan = new Scanner(System.in);
		Connection conn = ConnectionUtil.getConnection();
		String sql = "DELETE FROM accounts WHERE id = ? RETURNING id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println("Which ID would you like to delete?");
			int id = scan.nextInt();
			stmt.setInt(1, id);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				id = rs.getInt(1);
				logger.info("returned Employees id #" + id);
			}
		} catch (SQLException e1) {
			logger.error("Unable to delete User, SQL exception thrown.");
			System.out.println("OOPS! We need to restart!");
		}
		System.out.println("Customer deleted.");
		return false;
	}

}
