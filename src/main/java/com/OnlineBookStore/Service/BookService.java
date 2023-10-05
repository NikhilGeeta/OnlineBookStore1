package com.OnlineBookStore.Service;

import java.util.List;

import com.OnlineBookStore.Entity.Book;

public interface BookService {
	List<Book> getAllBooks();

	Book getBookByIsbn(String isbn);

	Book createBook(Book book);

	Book updateBook(Long id, Book book);

	boolean deleteBook(Long id);
}
