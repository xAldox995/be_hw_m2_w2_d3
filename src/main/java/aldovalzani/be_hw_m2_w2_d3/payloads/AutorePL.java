package aldovalzani.be_hw_m2_w2_d3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AutorePL {
    private String nome;
    private String cognome;
    private String email;
    private String data_di_nascita;
}
