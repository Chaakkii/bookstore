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

			books.add(new Book("Kissa", "Nainen", 1990, "101010A", 10.0));
			books.add(new Book("Koira", "Mies", 1990, "101010B", 10.0));
			books.add(new Book("Karhu", "Otso", 1991, "101010C", 11.0));
			books.add(new Book("Orava", "Kurre", 1992, "101010D", 10.5));

			bookRepository.saveAll(books);
			
		};

}
}