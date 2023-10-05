package com.OnlineBookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineBookStore.Entity.Book;
import com.OnlineBookStore.Service.BookService;

@RestController
@RequestMapping("/api/Book")
public class BookRestController {
	@Autowired
	private BookService bookService;

	// Endpoint to retrieve all books
	@GetMapping("/")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	// Endpoint to retrieve a book by ISBN
	@GetMapping("/{isbn}")
	public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
		Book book = bookService.getBookByIsbn(isbn);
		if (book != null) {
			return new ResponseEntity<>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle not found case
		}
	}

	// Endpoint to create a new book
	@PostMapping("/putdata")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book createdBook = bookService.createBook(book);
		return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
	}

	// Endpoint to update an existing book
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
		Book updatedBook = bookService.updateBook(id, book);
		if (updatedBook != null) {
			return new ResponseEntity<>(updatedBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle not found case
		}
	}

	// Endpoint to delete a book by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		boolean deleted = bookService.deleteBook(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle not found case
		}
	}
}
