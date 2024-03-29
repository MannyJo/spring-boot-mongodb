package com.example.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mongodb.Repository.BookRepository;
import com.example.mongodb.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll(Sort.by("id").ascending());
	}

	@Override
	public Book updateBook(Book update) {
		return getBookById(update.getId()).map(book -> bookRepository.save(update)).orElse(null);
	}

	@Override
	public Book addBook(Book book) {
		return bookRepository.insert(book);
	}

	@Override
	public int deleteBook(ObjectId id) {
		return getBookById(id).map(book -> {
			bookRepository.deleteById(id);
			return 1;
		}).orElse(0);
	}

	@Override
	public Optional<Book> getBookById(ObjectId id) {
		return bookRepository.findById(id);
	}

	@Override
	public void deleteAllBooks() {
		bookRepository.deleteAll();
	}

}
