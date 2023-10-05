package com.OnlineBookStore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineBookStore.Entity.Book;
import com.OnlineBookStore.Repository.BookRepository;

@Service
public class BookServiceimpl implements BookService {
	@Autowired
	private BookRepository BookRepo;

	@Override
	public List<Book> getAllBooks() {
		List<Book> all = BookRepo.findAll();
		return all;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return BookRepo.findByIsbn(isbn);
	}

	@Override
	public Book createBook(Book book) {
		return BookRepo.save(book);
	}

	@Override
	public Book updateBook(Long id, Book book) {
		Optional<Book> existingBook = BookRepo.findById(id);
		if (existingBook.isPresent()) {
			// Set the ID of the updated book to match the existing book
			book.setId(id);
			return BookRepo.save(book);
		} else {
			return null; // Handle not found case
		}
	}

	@Override
	public boolean deleteBook(Long id) {
		if (BookRepo.existsById(id)) {
			BookRepo.deleteById(id);
			return true;
		} else {
			return false; // Handle not found case
		}
	}

}
