package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {
	
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
		book2=new Book(1,"Spring","John",900);
		book3=new Book(1,"Jsp","Kathy",900);
		book4=new Book(1,"Monk","Robin",900);
		book5=new Book(1,"Secret","Rhonde",900);
		
		bookList=Arrays.asList(book1,book2,book3,book4,book5);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		bookList=null;
	}

	@Test
	void testShowMessage() {
		Mockito.when(bookService.greetMessage()).thenReturn("Great day");
		
		String actual=details.showMessage("Priya");
		assertEquals("Great day Priya", actual);
		
		String nactual=details.showMessage("Prachi");
		assertEquals("Great day Prachi", nactual);
		
	}
	@Test
	void testAnShowMessage() {
		Mockito.when(bookService.greetMessage()).thenReturn("Great day");
		String actual=details.showMessage("Helen");
		assertEquals("Wrong username", actual);
		
		String nactual=details.showMessage("Raj");
		assertEquals("Wrong username", nactual);
		
	}
	
	@Test
	void testByAuthor() throws BookNotFoundException
	{
		String author="Kathy";
		when(bookService.getAll()).thenReturn(bookList);
		List<Book> actualBooks=details.findByAuthor(author);
		List<Book> expectedBooks=Arrays.asList(book1,book3);
		assertEquals(expectedBooks, actualBooks);
	} 
	@Test 
	@DisplayName("Testing by author - emply list")
	void testGetByAuthorEmpty() throws BookNotFoundException{
		String author="Danny";
		List<Book> emptyList=new ArrayList<Book>();
		
		when(bookService.getAll()).thenReturn(emptyList);
		
		assertThrows(BookNotFoundException.class, ()-> details.findByAuthor(author));
	}
	
	@Test 
	@DisplayName("Testing by author - throws Exception")
	void testGetByAuthorException() throws BookNotFoundException{
		String author="Danny";
		
		when(bookService.getAll()).thenThrow(new BookNotFoundException());
	
		assertThrows(BookNotFoundException.class, ()-> details.findByAuthor(author));
	}
	
	@Test 
	@DisplayName("Testing by author - Null")
	void testGetByAuthorNull() throws BookNotFoundException{
		String author="Danny";
		
		when(bookService.getAll()).thenReturn(null);
		List<Book> actual=details.findByAuthor(author);
		assertNull(actual);
	}
	
	
	
	
	
	

	

}
