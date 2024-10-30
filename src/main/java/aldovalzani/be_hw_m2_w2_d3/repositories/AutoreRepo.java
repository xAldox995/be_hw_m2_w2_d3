package aldovalzani.be_hw_m2_w2_d3.repositories;

import aldovalzani.be_hw_m2_w2_d3.entities.AutoreEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoreRepo extends JpaRepository<AutoreEn, Long> {
    Optional<AutoreEn> findAuthorByEmail(String email);
}
