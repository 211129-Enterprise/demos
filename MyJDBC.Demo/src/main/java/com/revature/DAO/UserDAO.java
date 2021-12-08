package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

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
	public List<User> findAll() {
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

}
