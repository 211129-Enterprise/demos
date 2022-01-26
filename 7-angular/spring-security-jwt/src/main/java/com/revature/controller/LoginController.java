package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.UserRepository;
import com.revature.models.AuthRequest;
import com.revature.models.User;
import com.revature.util.JwtUtil;

@RestController
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * In order to access this end point, we need
	 * to pass a JWT token which is only generated by the
	 * method generateToken() which accepts a username and password.
	 * @return
	 */
	@GetMapping("/")
	public String login() {
		return "You've successfully logged in!";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		/**
		 * For the user login, once the authentication request reached the
		 * authentication filter, it will extract the username and password from the
		 * request payload. Spring security will create an Authentication object based
		 * on the username and password.
		 */
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			
		  	
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}

		/**
		 * If no exception is thrown, generate a token (in JSON format, 
		 * of course) to return to the client
		 */
		return jwtUtil.generateToken(authRequest.getUsername());
	}
	
}