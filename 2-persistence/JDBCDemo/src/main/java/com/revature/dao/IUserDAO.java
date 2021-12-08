package com.revature.dao;

public interface IUserDAO {
	
	//Insert or create
	int insert(User u);
	
	
	//Read: return 1, return all
	User findById(int id);
	User findByUsername(String username);
	
	
	//Update
	
	//Delete

}
