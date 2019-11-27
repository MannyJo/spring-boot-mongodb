package com.example.mongodb.controller;

import java.util.Collection;

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
		bookService.addBook(book);
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
	public Book getBookById(@PathVariable ObjectId id) {
		return bookService.getBookById(id).orElse(null);
	}
	
	@PutMapping
	public void updateBook(@RequestBody Book update) {
		System.out.println(update);
		System.out.println(bookService.updateBook(update));
	}

}
