package fr.diginamic.entite;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "compte")
public abstract class  Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "SOLDE")
    private double solde;


    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;

    @ManyToOne
    @JoinColumn(name = "OERATION_ID")
    private Set<Operation> operations;

    public Compte(){
        operations=new HashSet<Operation>();
        clients=new HashSet<Client>();
    }

    public Compte(String numero, double solde) {
        operations=new HashSet<Operation>();
        clients=new HashSet<Client>();

        this.numero = numero;
        this.solde = solde;

    }
}
