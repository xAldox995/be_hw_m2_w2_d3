package aldovalzani.be_hw_m2_w2_d3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "autori")
@Getter
@Setter
@NoArgsConstructor
public class AutoreEn {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    private String avatar;

    public AutoreEn(String cognome, LocalDate data_di_nascita, String email, String nome) {
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.email = email;
        this.nome = nome;
    }
}
