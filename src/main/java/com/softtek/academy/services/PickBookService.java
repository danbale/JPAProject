package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.Book;
import com.softtek.academy.domain.PickBook;
import com.softtek.academy.domain.User;

public interface PickBookService {
	
	public List<PickBook> getAllPBooks();
	
	public PickBook getPBookById();
	
	public void createPBook(Book book, User user);

}
