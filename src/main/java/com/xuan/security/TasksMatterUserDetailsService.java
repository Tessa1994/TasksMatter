package com.xuan.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xuan.bean.User;
import com.xuan.respository.UserRepository;

@Service
public class TasksMatterUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<User> users = userRepo.findByEmail(email);

		if (users.size() == 0) {
			throw new UsernameNotFoundException("No user present with email: " + email);

		} else {
			return new TasksMatterUserDetails(users.get(0));
		}
	}
}
