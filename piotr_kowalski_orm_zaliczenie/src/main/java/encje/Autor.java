package encje;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;

    private String nazwisko;

    private LocalDateTime dataUrodzenia;

    @Embedded
    private Address adres;

    public Autor() {}

    public Autor(String imie, String nazwisko, LocalDateTime dataUrodzenia, Address adres) {   // Long id,
        // this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.adres = adres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDateTime getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDateTime dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Address getAdres() {
        return adres;
    }

    public void setAdres(Address adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", adres=" + adres +
                '}';
    }

}
