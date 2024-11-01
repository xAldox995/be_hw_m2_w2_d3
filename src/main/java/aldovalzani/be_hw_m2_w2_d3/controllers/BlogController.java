package aldovalzani.be_hw_m2_w2_d3.controllers;

import aldovalzani.be_hw_m2_w2_d3.entities.BlogEn;
import aldovalzani.be_hw_m2_w2_d3.payloads.BlogPL;
import aldovalzani.be_hw_m2_w2_d3.services.BlogServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
http://localhost:3001/blog_posts
*/
@RestController
@RequestMapping("/blog_posts")
public class BlogController {

    @Autowired
    BlogServ blogServ;

    //GET generico
    @GetMapping
    public Page<BlogEn> findAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        return this.blogServ.findAllBlogs(page, size);
    }

    // POST http://localhost:3001/blog_posts + mettere body con classe payloads
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogEn saveBlog(@RequestBody BlogPL body) {
        return this.blogServ.saveBlog(body);
    }


    //GET specifico http://localhost:3001/blog_posts/{blog_id}
    @GetMapping("/{blog_id}")
    public BlogEn findById(@PathVariable long blog_id) {
        return this.blogServ.findBlogById(blog_id);
    }

    //PUT http://localhost:3001/blog_posts/{blog_id}+body
    @PutMapping("/{blog_id}")
    public BlogEn findByIdAndUpdate(@PathVariable long blog_id, @RequestBody BlogPL body) {
        return this.blogServ.findBlogByIdAndUp(blog_id, body);
    }

    //DELETE http://localhost:3001/blog_posts/{blog_id}
    @DeleteMapping("/{blog_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDel(@PathVariable long blog_id) {
        this.blogServ.findBlogByIdAndDel(blog_id);
    }


}
