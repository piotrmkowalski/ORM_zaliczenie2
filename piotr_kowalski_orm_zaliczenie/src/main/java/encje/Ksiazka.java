package encje;

import javax.persistence.*;

@Entity
@Table(name = "ksiazka")
public class Ksiazka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tytul;

    private Integer dataWydania;    // rok wydania

    private String isbn;

    public Ksiazka() {}

    public Ksiazka(String tytul, Integer dataWydania, String isbn) {    // Long id,
        // this.id = id;
        this.tytul = tytul;
        this.dataWydania = dataWydania;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Integer getDataWydania() {
        return dataWydania;
    }

    public void setDataWydania(Integer dataWydania) {
        this.dataWydania = dataWydania;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", dataWydania=" + dataWydania +
                ", isbn='" + isbn + '\'' +
                '}';
    }

}
