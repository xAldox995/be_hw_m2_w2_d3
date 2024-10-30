package aldovalzani.be_hw_m2_w2_d3.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bolgs")
@Getter
@Setter
@NoArgsConstructor
public class BlogEn {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempo_di_lettura;
    @ManyToOne
    @JoinColumn(name = "autore_id", referencedColumnName = "id")
    private AutoreEn autore;

    public BlogEn(String categoria, String contenuto, int tempo_di_lettura, String titolo) {
        this.categoria = categoria;
        this.contenuto = contenuto;
        this.cover = "https://picsum.photos/200/300";
        this.tempo_di_lettura = tempo_di_lettura;
        this.titolo = titolo;
    }
}
