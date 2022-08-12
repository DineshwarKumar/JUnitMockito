package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderTest {
	
	@Mock
	IBookService bookService;
	
	@InjectMocks
	OrderDetails details;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1;
	Book book2;
	Book book3;
	Book book4;
	Book book5;
	List<Book> bookList;
	@BeforeEach
	void setUp() throws Exception {
		book1=new Book(1,"Java","Kathy",900);
		book2=new Book(2,"Spring","John",900);
		book3=new Book(3,"Jsp","Kathy",900);
		book4=new Book(4,"Monk","Robin",900);
		book5=new Book(5,"Secret","Rhonde",900);
		
		bookList=Arrays.asList(book1,book2,book3,book4,book5);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		bookList=null;
		book1=null;
	}

	@Test @DisplayName("Testing book- returns one book instance")
	void testBookById() throws BookNotFoundException {
		
		doReturn(book1).when(bookService).getById(1);
		String actual=details.orderBook(1);
		assertEquals("Book Ordered", actual);
		
	}
	
	@Test @DisplayName("Testing book-returns Null")
	void testBookByIdNull() throws BookNotFoundException {
		
		doReturn(null).when(bookService).getById(10);
		String actual=details.orderBook(10);
		assertEquals("Out of stock", actual);
		
	}
	
	@Test @DisplayName("Testing book- throws Exception")
	void testBookByIdException() throws BookNotFoundException {
		
		doReturn(new BookNotFoundException("Invalid Id")).when(bookService).getById(20);
		String actual=details.orderBook(20);
		assertEquals("Technical issues", actual);
		
	}
	
	@Test @DisplayName("Testing add book- null")
	void testAddBookNull() throws BookNotFoundException {
		
		String actual=details.addBook(null);
		assertEquals("book not added", actual);
		
	}
	@Test @DisplayName("Testing add book- ")
	void testAddBook() throws BookNotFoundException {
		doNothing().when(bookService).addBook(book2);
		String actual=details.addBook(book2);
		assertEquals("book added", actual);
		
	}
	

}
