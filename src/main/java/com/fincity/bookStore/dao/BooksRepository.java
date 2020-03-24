package com.fincity.bookStore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fincity.bookStore.entity.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book,Integer>{
	
	@Query("SELECT DISTINCT new com.fincity.bookStore.entity.Book(book.bookId,book.title,book.publishedDate,book.isbn,book.author_id,book.category_id) "
			+ "FROM Book book, Author author, Category category "
			+ "WHERE author.authorId = book.author_id "
			+ "and book.category_id = category.categoryId "
			+ "and ( "
			+ "(length(:isbn) = 0 OR :isbn is null OR isbn = :isbn) "
			+ "and ( length(:published_date) = 0 OR :published_date is null OR  book.publishedDate = :published_date ) "
			+ "and ( length(:title) = 0 OR :title is null OR book.title = :title ) "
			+ "and ( length(:author_first_name) = 0 OR :author_first_name is null OR author.firstName = :author_first_name  ) "
			+ "and ( length(:author_last_name) = 0 OR :author_last_name is null OR author.lastName = :author_last_name ) "
			+ "and ( length(:category) = 0 OR :category is null OR category.category = :category ))"
	   )
	public List<Book> getBooksThrouhMultipleFilters(@Param("isbn") String isbn,
			@Param("published_date") String published_date,
			@Param("title") String title,
			@Param("author_first_name") String author_first_name,
			@Param("author_last_name") String author_last_name,
			@Param("category") String category);
	
	
}