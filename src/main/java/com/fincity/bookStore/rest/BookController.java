package com.fincity.bookStore.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fincity.bookStore.dao.BooksRepository;
import com.fincity.bookStore.dto.BookDTO;
import com.fincity.bookStore.entity.Book;
import com.fincity.bookStore.serviceImpl.AuthorServiceImpl;
import com.fincity.bookStore.serviceImpl.BookServiceImpl;
import com.fincity.bookStore.wrapper.BookDTOWrapper;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/book-store/rest/v1.0/books")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@Autowired
	BookDTOWrapper bookDTOWrapper;

	@RequestMapping(value = "/search", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam("title") String title,
			@RequestParam("publishedDate") String publishedDate,
			@RequestParam("isbn") String isbn,
			@RequestParam("authorFirstName") String authorFirstName,
			@RequestParam("authorLastName") String authorLastName,
			@RequestParam("category") String category){

		List<BookDTO> books = bookDTOWrapper.getfilteredBooksDTO(isbn, publishedDate, title, authorFirstName,authorLastName, category);
		
		if(books!=null)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(books);
		else
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Book> addBooks(@RequestBody Book book){

		Book savedBook = bookServiceImpl.save(book);
		
		if(savedBook!=null)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(savedBook);
		else
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		
	}
	
	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteBook(@PathVariable int bookId){

		Boolean isDeleted = bookServiceImpl.delete(bookId);
		
		if(isDeleted)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("success");
		else
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("error");
		
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BookDTO>> getAllBooks(){

		List<BookDTO> books = bookDTOWrapper.getAllBooksDTO();
		
		if(books!=null)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(books);
		else
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
	}
	
	@RequestMapping(value = "/get/{bookId}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<BookDTO> getBookByID(@PathVariable int bookId){

		BookDTO bookDTO = bookDTOWrapper.getBookDTO(bookId);
		
		if(bookDTO!=null)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(bookDTO);
		else
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		
	}
	
}
