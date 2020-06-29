package przyklad;

import dao.*;
import encje.*;
import hibUtil.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.*;

public class Demo {

    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        LocalDateTime ldt1 = LocalDateTime.of(2000,2,2,3,4);
        LocalDateTime ldt2 = LocalDateTime.of(2001,4,12,3,4);
        LocalDateTime ldt3 = LocalDateTime.of(2002,9,27,3,4);

        Address ad1 = new Address("Polska", "Wrocław", "Kluczborska");
        Address ad2 = new Address("Deutschland", "Dresden", "Gutzkowstrasse");
        Address ad3 = new Address("USA", "New York", "Broadway");

        Ksiazka ks1 = new Ksiazka("Hamlet", 2012, "333-33-333333-1-0");
        Ksiazka ks2 = new Ksiazka("Pan Tadeusz", 2007, "123-45-678910-2-3");
        Ksiazka ks3 = new Ksiazka("Przedwiośnie", 2018, "555-55-555555-6-3");

        Autor autor1 = new Autor("Wiliam", "Shakespeare", ldt1, ad1);
        Autor autor2 = new Autor("Adam", "Mickiewicz", ldt2, ad2);
        Autor autor3 = new Autor("Stefan", "Żeromski", ldt3, ad3);

        KsiazkaDAO ksiazkaDAO = new KsiazkaDAO(entityManager);
        AutorDAO autorDAO = new AutorDAO(entityManager);

        entityManager.getTransaction().begin();
        ksiazkaDAO.save(ks1);
        ksiazkaDAO.save(ks2);
        ksiazkaDAO.save(ks3);
        // entityManager.getTransaction().commit();
        // entityManager.getTransaction().begin();
        autorDAO.save(autor1);
        autorDAO.save(autor2);
        autorDAO.save(autor3);
        entityManager.getTransaction().commit();

        List<Ksiazka> ksiazki = ksiazkaDAO.findAll();
        for (Ksiazka ks : ksiazki) {
            System.out.println(ks);
        }

        List<Autor> autorzy = autorDAO.findAll();
        for (Autor autor : autorzy) {
            System.out.println(autor);
        }

        entityManager.getTransaction().begin();
        ksiazkaDAO.delete(ks3);
        autorDAO.delete(autor3);
        entityManager.getTransaction().commit();
        System.out.println("PO USUNIĘCIU REKORDU Z TABEL ksiazka ORAZ autor:");

        ksiazki = ksiazkaDAO.findAll();
        for (Ksiazka ks : ksiazki) {
            System.out.println(ks);
        }

        autorzy = autorDAO.findAll();
        for (Autor autor : autorzy) {
            System.out.println(autor);
        }

        System.out.println("POBIERAM Z OBYDWU TABEL REKORDY Z id=2.");
        Ksiazka ksiazka = ksiazkaDAO.findById(2L);
        Autor autor = autorDAO.findById(2L);
        System.out.println(ksiazka);
        System.out.println(autor);

        HibernateUtil.closeEntityManager();

    }

}
