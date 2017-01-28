package com.softtek.academy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softtek.academy.domain.Book;
import com.softtek.academy.repository.BookRepository;

@Component 
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	// Get the list of all the books in the DB
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// Get a single book from the list searching it by the ID
	@Override
	public Book getBookById(Long id) {
		return bookRepository.findOne(id);
	}


	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deteleBook(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBook() {
		// TODO Auto-generated method stub
		
	}

}
