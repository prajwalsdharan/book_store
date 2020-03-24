package com.fincity.bookStore.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.fincity.bookStore.dao.BooksRepository;
import com.fincity.bookStore.dto.BookDTO;
import com.fincity.bookStore.entity.Author;
import com.fincity.bookStore.entity.Book;
import com.fincity.bookStore.service.CRUDService;

@Service
public class BookServiceImpl implements CRUDService<Book>{

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BooksRepository booksRepo;
	
	@Override
	@Transactional
	public Book save(Book book) {
		Book savedBook = booksRepo.save(book);
		return savedBook;
	}

	@Override
	public Book get(int id) {
		return booksRepo.getOne(id);
	}

	@Override
	@Transactional
	public Boolean delete(int id) {
		try {
			booksRepo.deleteById(id);
			return true;
		} catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Book> get() {
		return booksRepo.findAll();
	}
	
	public List<Book> getFiltered(
			String isbn,
			String published_date,
			String title,
			String author_first_name,
			String author_last_name,
			String category) {
		
		return booksRepo.getBooksThrouhMultipleFilters(
				isbn,
				published_date,
				title,
				author_first_name,
				author_last_name,
				category);
	}
	
}
