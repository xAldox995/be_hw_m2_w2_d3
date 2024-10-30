package aldovalzani.be_hw_m2_w2_d3.repositories;

import aldovalzani.be_hw_m2_w2_d3.entities.AutoreEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepo extends JpaRepository<AutoreEn, Long> {

}
