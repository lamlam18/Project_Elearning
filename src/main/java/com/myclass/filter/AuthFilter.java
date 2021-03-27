package com.myclass.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthFilter extends BasicAuthenticationFilter {
	private UserDetailsService userDetailsService;

	public AuthFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailsService = userDetailsService;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader != null && !authorizationHeader.isEmpty()) {
			String token = authorizationHeader.replace("Bearer ", "");
			String email = Jwts.parser()
					.setSigningKey("ABCDEFGH")
					.parseClaimsJws(token)
					.getBody()
					.getSubject();

			//
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);

			// set thong tin user vao security
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null , 
					userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}
		chain.doFilter(request, response);
	}

}
