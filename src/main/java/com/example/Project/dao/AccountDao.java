package com.example.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.entities.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{
	Account findByUsername(String username);
}
