package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Convert;
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
@Table(name = "book")
@NamedNativeQueries({
	@NamedNativeQuery(
			name="updateBook",
			query="UPDATE books b ,"
					+ "SET"
					+ "b.book_name= :name,"
					+ "b.book_genre= :genre,"
					+ "b.book_author= :author,"
					+ "b.book_editor= :editorial,"
					+ "b.book_lng= :language,"
					+ "b.book_status= :available,"
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
	@Column(name = "book_id")
	private Long id;

	@Column(name = "book_name")
	private String name;

	@Column(name = "book_genre")
	private String genre;

	@Column(name = "book_author")
	private String author;

	@Column(name = "book_editor")
	private String editorial;

	@Column(name = "book_lng")
	private String language;

	@Column(name = "book_status")
	@Convert(converter = StatusConverter.class)
	private Boolean status;

	@Column(name = "book_year")
	private int year;

	
	public Book (){
		super();
	}
	
	public Book(Long id, String name, String genre, String author, String editorial, String language, Boolean status,
			int year) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.editorial = editorial;
		this.language = language;
		this.status = status;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + year;
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
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", genre=" + genre + ", author=" + author + ", editorial="
				+ editorial + ", language=" + language + ", status=" + status + ", year=" + year + "]";
	}
	
	
	
	
}