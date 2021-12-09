package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAO implements IUserDAO{
	
	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public int insert(User u) {
		// TODO Auto-generated method stub

		try {
			
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "INSERT INTO somersm.users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING somersm.users.id";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			
			ResultSet rs; 
			
			if((rs = stmt.executeQuery()) != null) {
				// if we return data, we can iterate over it with a cursor
				rs.next();
				
				int id = rs.getInt(1);
				
				logger.info("returned User id #" + id);
				
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return -1;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
