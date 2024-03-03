package hh.sof03.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin
@Controller
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping(value = "/categories")
    public @ResponseBody List<Category> getCategoryRest() {
        return (List<Category>) categoryRepository.findAll();
    }

    @GetMapping(value ="/categories/{id}")
    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
    
    @PostMapping("/categories")
    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
      
        
        return categoryRepository.save(category);
    }
    

}
