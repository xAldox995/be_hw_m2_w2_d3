package aldovalzani.be_hw_m2_w2_d3.repositories;

import aldovalzani.be_hw_m2_w2_d3.entities.BlogEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<BlogEn, Long> {

}
