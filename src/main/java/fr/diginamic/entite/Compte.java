package fr.diginamic.entite;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "compte")
public abstract class  Compte implements Serializable {
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

    @OneToMany(mappedBy = "compte",cascade = CascadeType.PERSIST)
    private Set<Operation> operations;
    {
        operations=new HashSet<Operation>();
        clients=new HashSet<Client>();
    }
    /**
     * constructeur vide
     */
    public Compte(){

    }


    /**
     * constructeur parametre
     * @param numero
     * @param solde
     */
    public Compte(String numero, double solde) {

        this.numero = numero;
        this.solde = solde;

    }

    /**
     * rajout d'un client dans la liste des clients variable clients
     * @param client
     */
    public void addClient(Client client){
        this.clients.add(client);
        if (!client.getComptes().contains(this)) {
            client.addCompte(this);
        }
    }

    /**
     * rajout d'une operation dans le compte
     * @param operation
     */
    public void addOperation(Operation operation){
        operation.setCompte(this);
    }

    /**
     * Getter
     *
     * @return clients
     */

    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Getter
     *
     * @return operations
     */

    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * affichage de tout sauf des listes
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( " ");
        sb.append("id= ").append(id);
        sb.append(", numero= '").append(numero).append('\'');
        sb.append(", solde= ").append(solde);
        return sb.toString();
    }

    /**
     * definition du equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte compte)) return false;
        return Double.compare(solde, compte.solde) == 0 && Objects.equals(id, compte.id) && Objects.equals(numero, compte.numero) && Objects.equals(clients, compte.clients) && Objects.equals(operations, compte.operations);
    }

}
