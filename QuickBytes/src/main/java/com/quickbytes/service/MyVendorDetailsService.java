package com.quickbytes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.quickbytes.model.Vendor;
import com.quickbytes.repository.VendorRepository;

@Service
public class MyVendorDetailsService implements UserDetailsService{

	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Vendor> vendor=vendorRepository.getByUsername(username);
		
		if(vendor==null)
			throw new UsernameNotFoundException("Username invalid!!!");
		
		List<GrantedAuthority> list=new ArrayList<>();
		SimpleGrantedAuthority sga=new SimpleGrantedAuthority("vendor");
		list.add(sga);
		
		User user=new User(vendor.get().getUsername(), vendor.get().getPassword(), list);
		return user;
	}
}