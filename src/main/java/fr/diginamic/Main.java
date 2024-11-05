package fr.diginamic;

import fr.diginamic.entite.Banque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em);
        Banque banque = new Banque();

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}