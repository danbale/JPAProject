package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
			name="updateBook",
			query="UPDATE books b ,"
					+ "SET"
					+ "b.book_name= :name,"
					+ "b.book_genre= :genre,"
					+ "b.book_author= :author,"
					+ "b.book_editorial= :editorial,"
					+ "b.book_language= :language,"
					+ "b.book_available= :available,"
					+ "b.book_year= :year"
					+ "WHERE b.book_id = :bookId",
					
					resultSetMapping = "updateBookResult")})
@SqlResultSetMappings({
	@SqlResultSetMapping(name="updateBookResult", 
			columns={ @ColumnResult(name="result")
			
			}),
	@SqlResultSetMapping(name="UserMapping"),})
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
