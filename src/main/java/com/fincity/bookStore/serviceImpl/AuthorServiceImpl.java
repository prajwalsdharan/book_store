package com.fincity.bookStore.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fincity.bookStore.dao.AuthorRepository;
import com.fincity.bookStore.entity.Author;
import com.fincity.bookStore.service.CRUDService;

@Service
public class AuthorServiceImpl implements CRUDService<Author>{

	private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

	@Autowired
	AuthorRepository authorRepo;
	
	public Author getUniqueAuthor(String firstName,String lastName)
	{
		return authorRepo.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	@Transactional
	public Author save(Author author) {
		return authorRepo.save(author);
	}

	@Override
	public Author get(int id) {
		return authorRepo.getOne(id);
	}

	@Override
	@Transactional
	public Boolean delete(int id) {
		try {
			authorRepo.deleteById(id);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Author> get() {
		return authorRepo.findAll();
	}
	
	
}
