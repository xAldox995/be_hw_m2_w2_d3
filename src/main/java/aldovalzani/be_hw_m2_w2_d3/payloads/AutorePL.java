package aldovalzani.be_hw_m2_w2_d3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AutorePL {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
}
