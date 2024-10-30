package aldovalzani.be_hw_m2_w2_d3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogPL {
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempo_di_lettura;
    private long id_autore;
}
