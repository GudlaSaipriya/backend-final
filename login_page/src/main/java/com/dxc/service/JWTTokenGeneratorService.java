package com.dxc.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dxc.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTTokenGeneratorService implements TokenGeneratorService  {
	
	@Value("${jwt.secret.key}")
	private String secretKey;

	@Override
	public Map<String, String> generateToken(User user) {
		String token = Jwts.builder()
		.setSubject(String.format("%s,%s", user.getUsername(), user.getUseremail()))//getting name and password
		.claim("role", user.getRole())//getting role
		.setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.HS256, secretKey)
		.compact();
		return Map.of("token",token);
	}

}
