package com.softtek.academy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.softtek.academy.domain.Book;
import com.softtek.academy.services.BookService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value = { "/dataset/default.xml" }, type = DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class BookServiceImplTest {
	
	@Autowired
	private BookService bookServiceImpl;

	@Test
	@DatabaseSetup(value="/dataset/scenario1.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testBookServiceListNotNull(){
		List<Book> bookList;
		bookList = bookServiceImpl.getAllBooks();
		System.out.println(bookList);
		System.out.println(bookList.size());
		Assert.assertNotNull(bookList);
	}
	
	

}
