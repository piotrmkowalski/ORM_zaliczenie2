package dao;

import encje.Ksiazka;

import javax.persistence.EntityManager;
import java.util.List;

public class KsiazkaDAO extends AbstractDAO<Ksiazka> {

    public KsiazkaDAO(EntityManager em) {

        super(em, Ksiazka.class);
    }

}
