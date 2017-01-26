package com.softtek.academy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Embeddable
public class BookDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "BOOK_NAME")
	private String name;

	@Column(name = "BOOK_GENRE")
	private String genre;

	@Column(name = "BOOK_AUTHOR")
	private String author;

	@Column(name = "BOOK_EDITOR")
	private String editorial;

	@Column(name = "BOOK_LNG")
	private String language;

	@Column(name = "BOOK_STATUS")
	@Convert(converter = StatusConverter.class)
	private Boolean status;

	@Column(name = "BOOK_YEAR")
	private int year;

	public BookDetails(String name, String genre, String author, String editorial, String language, Boolean status,
			int year) {
		super();
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.editorial = editorial;
		this.language = language;
		this.status = status;
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
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
		BookDetails other = (BookDetails) obj;
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

	public String getLenguage() {
		return language;
	}

	public void setLenguage(String language) {
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

}
