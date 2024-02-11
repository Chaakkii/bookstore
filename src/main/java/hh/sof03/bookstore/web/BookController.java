package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;


@Controller

public class BookController {

    @Autowired
    private BookRepository bookRepository;
   
    @GetMapping("/booklist")
    public String getIndex(Model model) {

        model.addAttribute("books", bookRepository.findAll());

     
        return "booklist";
    }

	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

    @PostMapping("/add")
    public String bookAdded(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

}
