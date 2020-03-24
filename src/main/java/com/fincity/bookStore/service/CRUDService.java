package com.fincity.bookStore.service;

import java.util.List;

import com.fincity.bookStore.entity.Book;

public interface CRUDService<T> {

	T save(T t);
	T get(int id);
	Boolean delete(int id);
	List<T> get();
	
}
