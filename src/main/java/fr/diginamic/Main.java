package fr.diginamic;

import fr.diginamic.entite.Adresse;
import fr.diginamic.entite.Banque;
import fr.diginamic.entite.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em);
        Banque banque = new Banque("Crédit agricole");
        Banque banque2 = new Banque("Caisse d'épargne");

        Client client1 = new Client("Jean","Jacques", LocalDate.of(1820, 5, 1),new Adresse(4,"avenue Goldman",34130,"Mauguioi"));
        Client client2 = new Client("franck","bouh", LocalDate.of(1995, 5, 1),new Adresse(4,"avenue Jacquue",34740,"Castelanau-le-lez"));
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}