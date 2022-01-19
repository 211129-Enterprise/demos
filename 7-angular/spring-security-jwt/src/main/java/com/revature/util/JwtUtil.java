package com.revature.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	/**
	 * The secret is a random string that the algorithm uses to encode/decode our
	 * tokens typically you have this stored on a secure server, and integrate it
	 * via the properties file.
	 * 
	 * 1. If the secret is stored in a (remote) secure server, there would be a
	 * mechanism to authenticate on that server and retrieve the token to be used in
	 * the application.
	 * 
	 * 2. If the token is saved and encrypted locally, you will need to decrypt it
	 * in order to use it.
	 */
	@Value("${jwt.secret}") // @Value reads to an array
	private String secret;

	// (3a)
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	// (3b)
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	// (2)
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * (1) Claims constitute the payload part of a JSON web token and represent a
	 * set of information exchanged between two parties. 
	 */
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {

		final String username = extractUsername(token); // Here we are extracting the "Subject" of the token
		
		// Ask: is the Subject (Username) of the token indeed equal to the UserDetails and is the token NOT expired?
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
