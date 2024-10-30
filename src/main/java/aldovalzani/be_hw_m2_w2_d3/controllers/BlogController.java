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
@RequestMapping("/blog_posts")
public class BlogController {
    //GET generico
    @GetMapping
    public List<BlogEn> findAll() {
    }

    // POST http://localhost:3001/blog_posts + mettere body con classe payloads
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogEn saveBlog(@RequestBody BlogPL body) {
    }


    //GET specifico http://localhost:3001/blog_posts/{blog_id}
    @GetMapping("/{blog_id}")
    public BlogEn findById(@PathVariable long blog_id) {
    }

    //PUT http://localhost:3001/blog_posts/{blog_id}+body
    @PutMapping("/{blog_id}")
    public BlogEn findByIdAndUpdate(@PathVariable long blog_id, @RequestBody BlogPL body) {
    }

    //DELETE http://localhost:3001/blog_posts/{blog_id}
    @DeleteMapping("/{blog_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDel(@PathVariable long blog_id) {
    }


}
