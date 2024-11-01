package aldovalzani.be_hw_m2_w2_d3.services;

import aldovalzani.be_hw_m2_w2_d3.entities.AutoreEn;
import aldovalzani.be_hw_m2_w2_d3.entities.BlogEn;
import aldovalzani.be_hw_m2_w2_d3.exceptions.NotFoundException;
import aldovalzani.be_hw_m2_w2_d3.payloads.BlogPL;
import aldovalzani.be_hw_m2_w2_d3.repositories.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<BlogEn> findAllBlogs(int page, int size) {
        if (size > 10) size = 10;
        Pageable pageable = PageRequest.of(page, size);
        return this.blogRepo.findAll(pageable);
    }

    public BlogEn findBlogById(long blogId) {
        return this.blogRepo.findById(blogId).orElseThrow(() -> new NotFoundException(blogId));
    }

    public BlogEn findBlogByIdAndUp(long blogId, BlogPL body) {
        BlogEn blogToUp = this.findBlogById(blogId);
        AutoreEn autoreBlog = autoreServ.findAuthorById(body.getId_autore());
        blogToUp.setCategoria(body.getCategoria());
        blogToUp.setContenuto(body.getContenuto());
        blogToUp.setTempo_di_lettura(body.getTempo_di_lettura());
        blogToUp.setTitolo(body.getTitolo());
        blogToUp.setAutore(autoreBlog);
        return this.blogRepo.save(blogToUp);
    }

    public void findBlogByIdAndDel(long blogId) {
        BlogEn blogToDel = this.findBlogById(blogId);
        this.blogRepo.delete(blogToDel);
    }
}
