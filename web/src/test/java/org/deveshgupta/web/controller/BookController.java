package org.deveshgupta.web.controller;

import java.util.List;

import org.deveshgupta.web.model.Book;
import org.deveshgupta.web.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public List<Book> getBookById(@PathVariable("id") Long id) {
		return bookRepository.findAll();
	}
}