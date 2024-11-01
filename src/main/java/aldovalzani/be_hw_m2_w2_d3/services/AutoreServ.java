package aldovalzani.be_hw_m2_w2_d3.services;

import aldovalzani.be_hw_m2_w2_d3.entities.AutoreEn;
import aldovalzani.be_hw_m2_w2_d3.exceptions.BadRequestException;
import aldovalzani.be_hw_m2_w2_d3.exceptions.NotFoundException;
import aldovalzani.be_hw_m2_w2_d3.payloads.AutorePL;
import aldovalzani.be_hw_m2_w2_d3.repositories.AutoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutoreServ {
    @Autowired
    private AutoreRepo autoreRepo;

    public AutoreEn saveAuthor(AutorePL body) {
        this.autoreRepo.findAuthorByEmail(body.getEmail()).ifPresent(
                author -> {
                    throw new BadRequestException("Email " + body.getEmail() + " già usata da un altro utente");
                }
        );
        AutoreEn newAuthor = new AutoreEn(body.getCognome(), body.getData_di_nascita(), body.getEmail(), body.getNome());
        System.out.println("Data di nascita ricevuta: " + body.getData_di_nascita());

        return this.autoreRepo.save(newAuthor);
    }

    public Page<AutoreEn> findAllAuthors(int page, int size) {
        if (size > 5) size = 5;
        Pageable pageable = PageRequest.of(page, size);
        return this.autoreRepo.findAll(pageable);
    }

    public AutoreEn findAuthorById(long authorId) {
        return this.autoreRepo.findById(authorId).orElseThrow(() -> new NotFoundException(authorId));
    }

    public AutoreEn findAuthorByIdAndUp(long authorId, AutorePL body) {
        AutoreEn authorFound = this.findAuthorById(authorId);

        if (!authorFound.getEmail().equals(body.getEmail())) {
            this.autoreRepo.findAuthorByEmail(body.getEmail()).ifPresent(
                    author -> {
                        throw new BadRequestException("Email " + body.getEmail() + " già in uso! Cambiare email");
                    }
            );
        }
        authorFound.setNome(body.getNome());
        authorFound.setCognome(body.getCognome());
        authorFound.setEmail(body.getEmail());
        authorFound.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + " + " + body.getCognome());

        return this.autoreRepo.save(authorFound);
    }

    public void findAuthorByIdAndDel(long authorId) {
        AutoreEn authorFound = this.findAuthorById(authorId);
        this.autoreRepo.delete(authorFound);
    }
}
