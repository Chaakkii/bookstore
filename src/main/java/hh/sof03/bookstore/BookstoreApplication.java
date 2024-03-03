package hh.sof03.bookstore;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			log.info("Save some categories");

			Category cat1 = new Category("Comic");
			categoryRepository.save(cat1);
			Category cat2 = new Category("Fiction");
			categoryRepository.save(cat2);
			Category cat3 = new Category("Sci-Fi");
			categoryRepository.save(cat3);
			Category cat4 = new Category("Biography");
			categoryRepository.save(cat4);

			List<Category> categories = new ArrayList<>();
			
			categories.add(cat1);
			categories.add(cat2);
			categories.add(cat3);
			categories.add(cat4);

			categoryRepository.saveAll(categories);

			List<Book> books = new ArrayList<>();

			books.add(new Book("Cristiano Ronaldo", "Guillem Balague", 2017, "9789174995381", 15.95, cat4));
			books.add(new Book("Messi", "Luca Caioli", 2024, "9789524101578", 11.95, cat4));
			books.add(new Book("Mbappé", "Cyril Collot", 2019, "9789523128293", 27.95, cat4));
			books.add(new Book("Neymar", "Luca Caioli", 2016, "9789523123861", 14.95, cat4));

			bookRepository.saveAll(books);

			log.info("Fetch all the books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("Fetch all the categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}



	};
}
}
