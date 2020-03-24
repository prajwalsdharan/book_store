package com.fincity.bookStore.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fincity.bookStore.dto.BookDTO;
import com.fincity.bookStore.entity.Author;
import com.fincity.bookStore.entity.Book;
import com.fincity.bookStore.entity.Category;
import com.fincity.bookStore.serviceImpl.AuthorServiceImpl;
import com.fincity.bookStore.serviceImpl.BookServiceImpl;
import com.fincity.bookStore.serviceImpl.CategoryServiceImpl;

@Component
public class BookDTOWrapper {

	@Autowired
	AuthorServiceImpl authorServiceImpl;

	@Autowired
	BookServiceImpl bookServiceImpl;

	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	public BookDTO getBookDTO(int id)
	{
		BookDTO bookDTO = null;
		try {
			Book book = bookServiceImpl.get(id);
			Author author = authorServiceImpl.get(book.getAuthor_id());
			Category category = categoryServiceImpl.get(book.getCategory_id());

			bookDTO = new BookDTO();
			bookDTO.setAuthorFirstName(author.getFirstName());
			bookDTO.setAuthorLastName(author.getLastName());
			bookDTO.setBookId(book.getBookId());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPublishedDate(book.getPublishedDate());
			bookDTO.setTitle(book.getTitle());
			bookDTO.setCategory(category.getCategory());
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return bookDTO;
	}

	public List<BookDTO> getAllBooksDTO()
	{
		List<BookDTO> bookDTOList = null;
		try {
			List<Book> bookList = bookServiceImpl.get();

			bookDTOList = new ArrayList<BookDTO>();
			for(Book book:bookList)
			{
				Author author = authorServiceImpl.get(book.getAuthor_id());
				Category category = categoryServiceImpl.get(book.getCategory_id());

				BookDTO bookDTO = new BookDTO();
				bookDTO.setAuthorFirstName(author.getFirstName());
				bookDTO.setAuthorLastName(author.getLastName());
				bookDTO.setBookId(book.getBookId());
				bookDTO.setIsbn(book.getIsbn());
				bookDTO.setPublishedDate(book.getPublishedDate());
				bookDTO.setTitle(book.getTitle());
				bookDTO.setCategory(category.getCategory());

				bookDTOList.add(bookDTO);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return bookDTOList;
	}
	
	public List<BookDTO> getfilteredBooksDTO(
			String isbn,
			String published_date,
			String title,
			String author_first_name,
			String author_last_name,
			String category_name)
	{
		List<BookDTO> bookDTOList = null;
		try {
			
			List<Book> bookList = bookServiceImpl.getFiltered(
					isbn,
					published_date,
					title,
					author_first_name,
					author_last_name,
					category_name);
			
			bookDTOList = new ArrayList<BookDTO>();
			for(Book book:bookList)
			{
				Author author = authorServiceImpl.get(book.getAuthor_id());
				Category category = categoryServiceImpl.get(book.getCategory_id());

				BookDTO bookDTO = new BookDTO();
				bookDTO.setAuthorFirstName(author.getFirstName());
				bookDTO.setAuthorLastName(author.getLastName());
				bookDTO.setBookId(book.getBookId());
				bookDTO.setIsbn(book.getIsbn());
				bookDTO.setPublishedDate(book.getPublishedDate());
				bookDTO.setTitle(book.getTitle());
				bookDTO.setCategory(category.getCategory());

				bookDTOList.add(bookDTO);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return bookDTOList;
	}
	
}
