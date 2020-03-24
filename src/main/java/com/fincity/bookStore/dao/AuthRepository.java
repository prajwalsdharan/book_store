package com.fincity.bookStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fincity.bookStore.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, Integer> {

	Auth findByUsernameAndPassword(String username, String password);

}
