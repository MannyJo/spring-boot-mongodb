package com.example.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.example.mongodb.model.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public Book updateBook(Book book);
	
	public Book addBook(Book book);
	
	public int deleteBook(ObjectId id);
	
	public Optional<Book> getBookById(ObjectId id);
	
	public void deleteAllBooks();

}
