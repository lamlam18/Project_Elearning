package com.myclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//
import com.myclass.filter.AuthFilter;

@Configuration
@EnableWebSecurity
@Order(value = 1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
	private UserDetailsService userDetailsService;

	public AdminSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	//một cách khác để khởi tạo
//	@Bean
//	public PasswordEncoder passEncode() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
//		.passwordEncoder(passEncode());
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/v2/api-docs",
		"/configuration/ui",
		"/swagger-resources/**",
		"/configuration/security",
		"/swagger-ui.html",
		"/webjars/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.antMatcher("/api/admin/**")
//		.authorizeRequests()
//		.antMatchers("/api/admin/login")
//		.permitAll()
//		.antMatchers("/api/admin/**")
//		.hasAnyRole("ADMIN")
//		.anyRequest()
//		.authenticated();
		
		http.addFilter(new AuthFilter(authenticationManager(), userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
