package com.example.Project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.AccountDao;
import com.example.Project.entities.Account;

import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

@Service
@Transactional
//UserDetailsService là của security 	  
public class UserLoginServiceImpl implements UserDetailsService {
	@Autowired
	AccountDao accountDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account acc = accountDao.findByUsername(username);
		if (acc == null) {
			// nếu không tìm thầy thì throw ra 1 exception
			throw new UsernameNotFoundException("no user");
		}

		// SimpleGrantedAuthority là list các quyền của acc
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(acc.getRole()));

		UserDetails details = new User(acc.getUsername(), acc.getPassword(), true, true, true, true, authorities);
		return details;
	}

}
