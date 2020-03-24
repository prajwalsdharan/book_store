package com.fincity.bookStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fincity.bookStore.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
