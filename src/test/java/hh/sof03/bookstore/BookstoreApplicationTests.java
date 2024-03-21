package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.web.BookController;
import hh.sof03.bookstore.web.BookRestController;
import hh.sof03.bookstore.web.CategoryController;
import hh.sof03.bookstore.web.CategoryRestController;

@AutoConfigureMockMvc
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private CategoryController categoryController;

	@MockBean
	private BookRestController bookRestController;

	@MockBean
	private CategoryRestController categoryRestController;

	@MockBean
	private BookRepository bookRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
	}

	@Test
	@WithMockUser(username = "testuser", password = "testpassword", roles="USER")
	public void testGetAllBooks() throws Exception {
		mockMvc.perform(get("/books"))
			.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "testuser", password = "testpassword", roles="USER")
	public void testGetBookById() throws Exception {
		mockMvc.perform(get("/books/1"))
			.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "testuser", password = "testpassword", roles="USER")
	public void testGetAllCategories() throws Exception {
		mockMvc.perform(get("/categories"))
			.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "testuser", password = "testpassword", roles="USER")
	public void testGetCategoryById() throws Exception {
		mockMvc.perform(get("/categories/1"))
			.andExpect(status().isOk());
	}





}
