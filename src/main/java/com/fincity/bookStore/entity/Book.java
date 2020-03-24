package com.fincity.bookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.UniqueConstraint;

@Entity
@Table
(
		name = "books",uniqueConstraints=
		@UniqueConstraint(columnNames={"title", "author_id","category_id"})
)
public class Book {
	
	Book()
	{
		super();
	}
	
	public Book(Integer id,@NotNull(message = "Title is required") String title, String publishedDate, String isbn,
			@NotNull(message = "Author is required") int author_id,
			@NotNull(message = "Category is required") int category_id) {
		super();
		this.bookId = id;
		this.title = title;
		this.publishedDate = publishedDate;
		this.isbn = isbn;
		this.author_id = author_id;
		this.category_id = category_id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true, nullable = false)
	private Integer bookId;
	
	@NotNull(message="Title is required")
	@Column(name = "title", length = 255)
	private String title;
	
	@Column(name = "published_date", nullable = true, length = 100)
	private String publishedDate;
	
	@Column(name = "isbn", nullable = true, length = 50)
	private String isbn;
	
	@NotNull(message="Author is required")
	private int author_id;
	
	@NotNull(message="Category is required")
	private int category_id;

	
	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
