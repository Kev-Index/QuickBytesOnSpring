package com.quickbytes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.quickbytes.service.UserService;

@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService userService;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		return pe;
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

			.antMatchers("/user").permitAll()
//			.antMatchers("/customer").hasAnyAuthority("customer","admin")
//			.antMatchers("/admin").hasAuthority("admin")
//			.antMatchers("/vendors").permitAll()
//			.antMatchers("/requests").permitAll()
//			.antMatchers("/request").permitAll()
//			.antMatchers("/requestitem").permitAll()
//			.antMatchers("/requestcombo").permitAll()
//			.antMatchers("/combos").hasAnyAuthority("vendor", "admin")
//			.antMatchers("/combo").hasAnyAuthority("vendor", "admin")
//			.antMatchers("/combo/{cid}").hasAnyAuthority("vendor", "admin")
//			.antMatchers("/combo/{name}").hasAnyAuthority("vendor", "admin")
//			.antMatchers("/combos/vendorId/{vid}").hasAnyAuthority("vendor", "admin")
//			.antMatchers("/vendor/{id}").hasAnyAuthority("vendor", "admin")
//			.antMatchers("/vendor/{name}").hasAnyAuthority("vendor", "admin")
//			.antMatchers("vendor/single/{vid}").hasAnyAuthority("vendor", "admin")
			
			// Use for testing
			.antMatchers(HttpMethod.GET, "/login").authenticated()
			.and().httpBasic()
			.and().csrf().disable();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getCustomerProvider());
	}
	
	
	private DaoAuthenticationProvider getCustomerProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(userService);
		return dao;
	}
}
