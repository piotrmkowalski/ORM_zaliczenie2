package dao;

import encje.Autor;

import javax.persistence.EntityManager;
import java.util.List;

public class AutorDAO extends AbstractDAO<Autor> {

    public AutorDAO(EntityManager em) {

        super(em, Autor.class);
    }

}
