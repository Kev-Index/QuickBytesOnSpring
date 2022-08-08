package com.quickbytes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
			.antMatchers("/user").hasAnyAuthority("admin")
			.antMatchers("/customer").hasAnyAuthority("customer","admin")
			.antMatchers("/admin").hasAuthority("admin")
			.antMatchers("/vendors").hasAnyAuthority("Vendor", "admin")
			.antMatchers("/combos").hasAnyAuthority("Vendor", "admin")
			.antMatchers("/combo").hasAnyAuthority("Vendor", "admin")
			.antMatchers("/combo/{cid}").hasAnyAuthority("Vendor", "admin")
			.antMatchers("/combo/{name}").hasAnyAuthority("Vendor", "admin")
			.antMatchers("/combos/vendorId/{vid}").hasAnyAuthority("Vendor", "admin")
			.antMatchers("/vendor/{id}").hasAnyAuthority("Vendor", "admin")
			.antMatchers("/vendor/{name}").hasAnyAuthority("Vendor", "admin")
			.antMatchers("vendor/single/{vid}").hasAnyAuthority("Vendor", "admin")
			
			// Use for testing
			// .antMatchers(HttpMethod.POST, "/user").permitAll()
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
