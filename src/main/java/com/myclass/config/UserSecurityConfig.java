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

import com.myclass.filter.AuthFilter;

@Configuration
@EnableWebSecurity
@Order(value = 2)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter{
	public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
		private UserDetailsService userDetailsService;

		public AdminSecurityConfig(UserDetailsService userDetailsService) {
			this.userDetailsService = userDetailsService;
		}

		//một cách khác để khởi tạo
//		@Bean
//		public PasswordEncoder passEncode() {
//			return new BCryptPasswordEncoder();
//		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth
			.userDetailsService(userDetailsService)
//			.passwordEncoder(passEncode());
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
//			http.csrf().disable()
//			.antMatcher("/api/**")
//			.authorizeRequests()
//			.antMatchers("/api/user/profile")
//			.authenticated();
			
			http.addFilter(new AuthFilter(authenticationManager(), userDetailsService));
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
	}
}
