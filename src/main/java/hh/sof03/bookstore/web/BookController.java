package hh.sof03.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;

public class BookController {

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

}
