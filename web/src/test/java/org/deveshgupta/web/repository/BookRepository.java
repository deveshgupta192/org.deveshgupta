package org.deveshgupta.web.repository;

import java.util.List;

import org.deveshgupta.web.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}