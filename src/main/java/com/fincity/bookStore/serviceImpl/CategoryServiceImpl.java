package com.fincity.bookStore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fincity.bookStore.dao.CategoryRepository;
import com.fincity.bookStore.entity.Category;
import com.fincity.bookStore.service.CRUDService;

@Service
public class CategoryServiceImpl implements CRUDService<Category>{

	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public Category save(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category get(int id) {
		return categoryRepo.getOne(id);
	}

	@Override
	public Boolean delete(int id) {
		try {
			categoryRepo.deleteById(id);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Category> get() {
		return categoryRepo.findAll();
	}

}
