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

import com.quickbytes.service.MyVendorDetailsService;






@Configuration
public class VendorApiSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyVendorDetailsService myVendorDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/vendors").authenticated()
			.antMatchers("/combos").authenticated()
			.antMatchers("/combo").authenticated()
			.antMatchers("/combo/{cid}").authenticated()
			.antMatchers("/combo/{name}").authenticated()
			.antMatchers("/combos/vendorId/{vid}").authenticated()
			.antMatchers("/vendor/{id}").authenticated()
			.antMatchers("/vendor/{name}").authenticated()
			.antMatchers("vendor/single/{vid}").authenticated()
			.anyRequest().permitAll()
			.and().httpBasic()
			.and().csrf().disable();
	}
 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		

				
		auth.authenticationProvider(getCustomProvider());
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	
	private DaoAuthenticationProvider getCustomProvider(){
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myVendorDetailsService);
		return dao;
	}
}