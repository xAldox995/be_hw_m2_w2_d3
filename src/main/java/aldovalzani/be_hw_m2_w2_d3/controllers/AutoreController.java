package aldovalzani.be_hw_m2_w2_d3.controllers;

import aldovalzani.be_hw_m2_w2_d3.entities.AutoreEn;
import aldovalzani.be_hw_m2_w2_d3.payloads.AutorePL;
import aldovalzani.be_hw_m2_w2_d3.services.AutoreServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
http://localhost:3001/autori
 */

@RestController
@RequestMapping("/autori")

public class AutoreController {

    @Autowired
    private AutoreServ autoreServ;

    @GetMapping
    public Page<AutoreEn> findAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size) {
        return this.autoreServ.findAllAuthors(page, size);
    }

    // POST http://localhost:3001/autori + mettere body con classe payloads
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreEn saveBlog(@RequestBody AutorePL body) {
        return this.autoreServ.saveAuthor(body);
    }


    //GET specifico http://localhost:3001/blog_posts/{blog_id}
    @GetMapping("/{autori_id}")
    public AutoreEn findById(@PathVariable long autori_id) {
        return this.autoreServ.findAuthorById(autori_id);
    }

    //PUT http://localhost:3001/blog_posts/{blog_id}+body
    @PutMapping("/{autori_id}")
    public AutoreEn findByIdAndUpdate(@PathVariable long autori_id, @RequestBody AutorePL body) {
        return this.autoreServ.findAuthorByIdAndUp(autori_id, body);
    }

    //DELETE http://localhost:3001/blog_posts/{blog_id}
    @DeleteMapping("/{autori_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDel(@PathVariable long autori_id) {
        this.autoreServ.findByAndDel(autori_id);
    }

}
