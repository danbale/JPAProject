package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.Book;


public interface BookService {

	public List<Book> getAllBooks();

	public Book getBookById(Long id);

	public void createBook();

	public boolean updateBook(Book book);

	public void deteleBook(Long id);
}
