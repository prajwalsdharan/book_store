package com.fincity.bookStore.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
@Entity
@Table
(
		name = "authors",uniqueConstraints=
		@UniqueConstraint(columnNames={"first_name","last_name"})
)
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id", unique = true, nullable = false)
	private Integer authorId;
	 
	@NotNull(message="First name is required")
	@Column(name = "first_name", length = 100)
	private String firstName;
	 
	@NotNull(message="Last name is required")
	@Column(name = "last_name", length = 100)
	private String lastName;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.MERGE)
	@JoinColumn(name="author_id")
    private Set<Book> books; 

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	 
}
