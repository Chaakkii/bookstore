package hh.sof03.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.CategoryRepository;


@Controller

public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
   
    @GetMapping("/booklist")
    public String getIndex(Model model) {

        model.addAttribute("books", bookRepository.findAll());

     
        return "booklist";
    }

	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}

    @PostMapping("/add")
    public String bookAdded(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            return "edit";
        } else {
            return "redirect:/booklist";
        }
    }


    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book updatedBook) {
        Book isBook = bookRepository.findById(id).orElse(null);

        if (isBook != null) {
            isBook.setTitle(updatedBook.getTitle());
            isBook.setAuthor(updatedBook.getAuthor());
            isBook.setIsbn(updatedBook.getIsbn());
            isBook.setPublicationYear(updatedBook.getPublicationYear());
            isBook.setPrice(updatedBook.getPrice());

            bookRepository.save(isBook);
        

        return "redirect:/booklist";
    } else {
        return "redirect:/booklist";
    }

 
}
   @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
