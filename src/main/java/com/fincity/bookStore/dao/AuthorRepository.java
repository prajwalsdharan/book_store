package com.fincity.bookStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fincity.bookStore.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer>{

	public Author findByFirstNameAndLastName(String firstName,String lastName);
	
}
