package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails  {
	IBookService bookService;
	
	public String showMessage(String name) {
		String result=bookService.greetMessage();
		if (name.startsWith("P")) {
			return result.concat(" ").concat(name);
		} else {
			return "Wrong username";
		}
	}
	
	public void setBookService(IBookService bookService) {
		this.bookService=bookService;
	}
	
	public List<Book> findByAuthor(String author) throws BookNotFoundException{
		List<Book> book=bookService.getAll();
		if(book==null)
			return null;
		
		if(book.isEmpty())
			throw new BookNotFoundException();
		return book.stream().filter((name)->name.getAuthor().equals(author)).collect(Collectors.toList());
		
	}
	
	public String orderBook(int bookId)
	{
		try {
			Book book=bookService.getById(bookId);
			if(book==null)
				return "Out of stock";
			return "Book Ordered";
			
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Technical issues";
	}
	
	public String addBook(Book book){
		if(book==null)
			return "book not added";
		bookService.addBook(book);
		return "book added";
	}
	


}
