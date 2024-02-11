package hh.sof03.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {

			List<Book> books = new ArrayList<>();

			books.add(new Book("Cristiano Ronaldo", "Guillem Balague", 2017, "9789174995381", 15.95));
			books.add(new Book("Messi", "Luca Caioli", 2024, "9789524101578", 11.95));
			books.add(new Book("Mbappé", "Cyril Collot", 2019, "9789523128293", 27.95));
			books.add(new Book("Neymar", "Luca Caioli", 2016, "9789523123861", 14.95));

			bookRepository.saveAll(books);
			
		};

}
}