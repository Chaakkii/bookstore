package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;


@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveAndSearchBook() {
        Category cat5 = new Category("Test Category");
		categoryRepository.save(cat5);

        Book book = new Book("Test Book", "Test Author", 2024, "1234567890", 15.00, cat5);

        bookRepository.save(book);

        Book foundBook = bookRepository.findById(book.getId()).orElse(null);

        assertThat(foundBook).isNotNull();


    }

    @Test
    public void testDeleteBook() {
        Category cat5 = new Category("Test Category");
		categoryRepository.save(cat5);

        Book book = new Book("Test Book", "Test Author", 2024, "1234567890", 15.00, cat5);

        bookRepository.save(book);

        bookRepository.deleteById(book.getId());

        assertThat(bookRepository.findById(book.getId())).isEmpty();

    }







    
    
}
