package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	int insert(User u);
	
	User findById(int id);
	
	User findByUsername(String username);
	
	List<User> findAll();
	
	boolean update(User u);
	
	boolean delete(int id);
}
