package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utilt.ConnectionUtil;

public class UserDAO  implements IUserDAO{
	
	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public int insert(User u) {
			try {
				
				 System.out.println("before ===>");
				
			Connection conn =  ConnectionUtil.getConnection();
			
			System.out.println(conn);
			
			System.out.println("here ======>");
		
			String sql = "INSERT INTO users (username , pwd ,user_role) Values(?,?,?) RETURNING users.user_id";
		
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		// TODO Auto-generated method stub
		
		// 1- capture a db connection 
		//2 - generate a sql stetement insert into users (username , pwd , role );
		// 2-b use a prepare statement to do this to avoid sql injections
		//process 
			
			stmt.setString(1, u.getUsername() );
			stmt.setString(1, u.getPassword() );
			
			// insert ENUM IMPORTANT 
			
			stmt.setObject(3, u.getRole() ,Types.OTHER);
			
		// use a result set to extract the primary kkey from the user object that was persited 
			
			
			ResultSet rs;
			
			if((rs = stmt.executeQuery()) != null) {
				// if we get data we can iterate over it 
				rs.next();
				
				//capture the first data return which is the Id of the user
				int id = rs.getInt(1);
				
				logger.info("returned User id #" + id);
				
				return id ;
				
			}
			}catch(SQLException e) {
				logger.error("UNable to inser User -SQL excetion thrown ");
			}
			
		
		// return -1 if unseccefull, other return pk of the persisted user object
		
		
		
		
		// return -1 if unsucceful , other return the PK of the persited Use object
		// 	
		return -1;
	}

	@Override
	public User findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> allusers = new LinkedList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			java.sql.Statement stmt = conn.createStatement();
			
			String sql = "\r\n"
					+ "SELECT users.id, users.username, users.pwd, users.user_role, accounts.id AS account_id, accounts.balance, \r\n"
					+ "accounts.active \r\n"
					+ "	FROM users\r\n"
					+ "	LEFT JOIN users_accounts_jt ON users.id = users_accounts_jt.acc_owner\r\n"
					+ "	LEFT JOIN accounts ON accounts.id = users_accounts_jt.account" ;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// grab id , username, password , role 
				
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("pwd");
				
				Role role = Role.valueOf(rs.getString("user_role"));
				
				int accId = rs.getInt("account_id");
				double balance = rs.getDouble("balance");
				boolean isActive = rs.getBoolean("active");
				
				// if the account ID is zero that mean the user dosent have an account
				
				if(accId == 0) {
					allusers.add(new User(id , username, password, role, new LinkedList<>()));
					
//					
//					public User(int id, String username, String password, Role role, List<Account> accounts) {
//						super();
//						this.id = id;
//						this.username = username;
//						this.password = password;
//						this.role = role;
//						this.accounts = accounts;
//					}
//					
					
				}else {
					Account a = new Account(accId,  balance,id ,isActive);
					
					
					List<User> potentialOwners = allusers.stream()
							.filter((u)-> u.getId() == id)
							.collect(Collectors.toList());
					
					
					if(potentialOwners.isEmpty()){
						List<Account> owerdAccounts = new LinkedList<>();
						owerdAccounts.add(a);
						User u = new User(id , username, password, role , owerdAccounts);
						allusers.add(u);
					}else {
						
						User u = potentialOwners.get(0);
						
					}
					
					
					
				}
				
				// create 
			}
	
			
		}catch(SQLException e) {
			logger.warn("SQL Exception throw - can't retrive all users from DB");
			e.printStackTrace();
		}
		
		
		return allusers;
	}
	
	

}
