package fr.diginamic;

import fr.diginamic.entite.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(em);
        Banque banque = new Banque("Credit agricole");
        Banque banque2 = new Banque("Caisse d'epargne");

        Client client1 = new Client("Jean","Jacques", LocalDate.of(1820, 5, 1),new Adresse(4,"avenue Goldman",34130,"Mauguio"),banque);
        Client client2 = new Client("franck","bouh", LocalDate.of(1995, 5, 1),new Adresse(4,"avenue Jacquue",34740,"Castelanau-le-lez"),banque);



        LivretA livretA =new LivretA("24",200.24,0.74);
        AssuranceVie assuranceVie=new AssuranceVie("24",200.24,LocalDate.of(2050,8,23),2);
        Virement virement=new Virement(LocalDateTime.of(2024,11,6,11,40),"loyer",746.52,"proprietaire",livretA);



        livretA.addClient(client1);
        assuranceVie.addClient(client1);
        client2.addCompte(assuranceVie);
        client2.addCompte(livretA);


        em.persist(banque);
        em.persist(banque2);

        em.getTransaction().commit();

        Client c = em.find(Client.class,1);
        if (c != null) {
            System.out.println(c);
        }
        Banque b = em.find(Banque.class,1);
        if (b != null) {
            System.out.println(b.getClients());
        }

        em.close();
        emf.close();
    }

}