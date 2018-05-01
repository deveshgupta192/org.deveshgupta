package org.deveshgupta.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.deveshgupta.web.model.Book;
import org.deveshgupta.web.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService implements IService<Book> {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book getById(Long id) {
		return bookRepository.findById(id).orElseThrow( () -> new );
	}

	@Override
	public Book create(Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Long id, Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Book t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
