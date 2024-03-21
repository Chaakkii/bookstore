package hh.sof03.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;


@DataJpaTest

public class CategoryRepositoryTest {

        @Autowired
        private CategoryRepository categoryRepository;

        @Test
        public void findByNameShouldReturnCategory() {

            Category testCategory = new Category("Test Category");
			categoryRepository.save(testCategory);

            List<Category> categories = categoryRepository.findByName("Test Category");

            assertThat(categories).hasSize(1);
            assertThat(categories.get(0).getName()).isEqualTo("Test Category");
        }

        @Test
        public void createNewCategory() {

            Category testCategory = new Category("Test Category");
			categoryRepository.save(testCategory);

            assertThat(testCategory.getCategoryid()).isNotNull();


        }

        @Test
        public void deleteCategoryById() {

            Category testCategory = new Category("Test Category");
			categoryRepository.save(testCategory);

            categoryRepository.deleteById(testCategory.getCategoryid());

            assertThat(categoryRepository.findById(testCategory.getCategoryid())).isEmpty();



        }
    
}
