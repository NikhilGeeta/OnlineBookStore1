package com.OnlineBookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.OnlineBookStore.Entity.Book;
import com.OnlineBookStore.Service.BookService;

@Controller
//@RequestMapping("/books") // Base URL for the web pages

public class BookController {

	@Autowired
	private BookService bookService;

//   http://localhsot:8080/showHomePage
	@RequestMapping("/showHomePage")
	public String homePage(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("book", books);
		return "homepage";
	}

	@RequestMapping("/books/{isbn}")
	public String showBookDetails(@PathVariable String isbn, Model model) {
		// Retrieve book details by ISBN and add them to the model
		Book book = bookService.getBookByIsbn(isbn);
		model.addAttribute("book", book);
		return "book-details"; // This is the name of the JSP file for displaying book details
	}

	@RequestMapping("/purchase/{isbn}")
	public String simulatePurchase(@PathVariable String isbn) {
	    // Retrieve the book by ISBN 
	    Book book = bookService.getBookByIsbn(isbn);

	    if (book != null) {
	        // Check if there are enough books in stock for the purchase
	        if (book.getQuantityInStock() > 0) {
	            // Decrement the quantity in stock
	            book.setQuantityInStock(book.getQuantityInStock() - 1);
	            // Save the updated book (You should have a method in your service to do this)
	            bookService.updateBook(book.getId(), book);
	            // Redirect to a success page
	            return "redirect:/purchase-success";
	        } else {
	            // Redirect to a page indicating that the book is out of stock
	            return "redirect:/purchase-failure?reason=out-of-stock";
	        }
	    } else {
	        // Redirect to a page indicating that the book was not found
	        return "redirect:/purchase-failure?reason=not-found";
	    }
	}
	@RequestMapping("/purchase-success")
	public String purchaseSuccess() {
	    return "purchase-success"; // This maps to the purchase-success.jsp page
	}

	@RequestMapping("/purchase-failure")
	public String purchaseFailure() {
	    return "purchase-failure"; // This maps to the purchase-failure.jsp page
	}
}
