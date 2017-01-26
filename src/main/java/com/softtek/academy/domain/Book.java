package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@NamedNativeQueries({
	@NamedNativeQuery(
			name="showBooks",
			query="SELECT "
					+ "b.book_name as name, "
					+ "b.book_genre as genre,"
					+ "b.book_author as author, "
					+ "b.book_editor as editorial, "
					+ "b.book_lng as language, " 
					+ "b.book_status as available"
					+ "b.book_year as year"
					+" FROM books b ",
					resultSetMapping = "BooksMapping")})
@SqlResultSetMappings({
	@SqlResultSetMapping(name="BooksMapping",
			classes= {
					@ConstructorResult(
							targetClass = Book.class,
							columns = {
								@ColumnResult(name = "name", type = String.class),
								@ColumnResult(name = "genre", type = String.class),
								@ColumnResult(name = "author", type = String.class),
								@ColumnResult(name = "editorial", type = String.class),
								@ColumnResult(name = "language", type = String.class),
								@ColumnResult(name = "available", type = Boolean.class),
								@ColumnResult(name = "year", type =Integer.class)
							})
			}),
	@SqlResultSetMapping(name="UserMapping"),})
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BOOK_ID")
	private Long id;

	@Embedded
	private BookDetails bookDetails;
	
	
	public Book(Long id, String name, String genre, String author, String editorial, String language, Boolean status,
			int year) {
		super();
		this.id = id;
		this.bookDetails = new BookDetails(name, genre, author, editorial, language, status, year);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookDetails == null) ? 0 : bookDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookDetails == null) {
			if (other.bookDetails != null)
				return false;
		} else if (!bookDetails.equals(other.bookDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookDetails getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

}
