package com.example.mongodb.controller;

import java.util.Collection;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.model.Book;
import com.example.mongodb.service.BookServiceImpl;

@RestController
@RequestMapping("api/book")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@GetMapping
	public Collection<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping
	public void addBook(@RequestBody Book book) {
		Book addedBook = bookService.addBook(book);
		System.out.println("Added Book : " + addedBook.toString());
	}
	
	@DeleteMapping("delete/all")
	public void deleteAll() {
		bookService.deleteAllBooks();
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteBookById(@PathVariable ObjectId id) {
		bookService.deleteBook(id);
	}
	
	@GetMapping("{id}")
	public Optional<Book> getBookById(@PathVariable ObjectId id) {
		return bookService.getBookById(id);
	}
	
	@PutMapping
	public void updateBook(@RequestBody Book update) {
		Book updatedBook = bookService.updateBook(update);
		System.out.println("Updated Book : " + updatedBook.toString());
	}

}
