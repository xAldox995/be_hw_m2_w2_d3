package aldovalzani.be_hw_m2_w2_d3.controllers;

import aldovalzani.be_hw_m2_w2_d3.entities.BlogEn;
import aldovalzani.be_hw_m2_w2_d3.payloads.BlogPL;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
http://localhost:3001/blog_posts
*/
@RestController
@RequestMapping("blog_posts")
public class BlogController {

    @GetMapping
    public List<BlogEn> findAll() {
    }

    // POST http://localhost:3001/blog_posts + mettere body con classe payloads
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogEn saveBlog(@RequestBody BlogPL body) {
    }


}
