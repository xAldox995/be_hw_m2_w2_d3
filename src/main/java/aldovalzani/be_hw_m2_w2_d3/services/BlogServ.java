package aldovalzani.be_hw_m2_w2_d3.services;

import aldovalzani.be_hw_m2_w2_d3.entities.AutoreEn;
import aldovalzani.be_hw_m2_w2_d3.entities.BlogEn;
import aldovalzani.be_hw_m2_w2_d3.payloads.BlogPL;
import aldovalzani.be_hw_m2_w2_d3.repositories.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServ {
    @Autowired
    private BlogRepo blogRepo;
    @Autowired
    private AutoreServ autoreServ;

    public BlogEn saveBlog(BlogPL body) {
        AutoreEn autoreForPost = autoreServ.findAuthorById(body.getId_autore());
        BlogEn newBlog = new BlogEn(body.getCategoria(), body.getContenuto(), body.getTempo_di_lettura(), body.getTitolo());
        newBlog.setAutore(autoreForPost);
        return this.blogRepo.save(newBlog);
    }
}
