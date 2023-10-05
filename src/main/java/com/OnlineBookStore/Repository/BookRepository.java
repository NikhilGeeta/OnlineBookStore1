package com.OnlineBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineBookStore.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	Book findByIsbn(String isbn);

}
