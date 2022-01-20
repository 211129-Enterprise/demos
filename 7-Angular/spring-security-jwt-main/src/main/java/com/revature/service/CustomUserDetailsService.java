package com.revature.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.data.UserRepository;
import com.revature.models.User;

/**
 * The UserDetailsService interface is used to retrieve user-related data. It
 * has one method named loadUserByUsername() which can be overridden to
 * customize the process of finding the user. It is used by the
 * DaoAuthenticationProvider to load details about the user during
 * authentication
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	/**
	 * This method returns a special User object with all the necessary infomration
	 * for Spring Security to authenticate the User.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.findByUsername(username);

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());

	}
}
