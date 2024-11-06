package fr.diginamic.entite;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column (name = "NOM")
    private String nom;

    @OneToMany (mappedBy = "banque")
    private Set<Client> clients;

    /**
     * constructeur vide
     */
    public Banque(){
    this.clients =new HashSet<Client>();
    }


    /**
     * constructeur avec que le nom
     * @param nom
     */
    public Banque(String nom) {
        this.clients =new HashSet<Client>();
        this.nom = nom;
    }


    /**
     * Setter
     *
     * @param client client
     */


    public void addClient(Client client) {
        this.clients.add(client);

        if (client.getBanque()==null ) {
            client.setBanque(this);
        } else if (!client.getBanque().equals(this)) {
            client.setBanque(this);
        }
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
     * affichage de tout sauf des clients associé
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banque{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');

        sb.append("} \n");

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
        if (!(o instanceof Banque banque)) return false;
        return Objects.equals(id, banque.id) && Objects.equals(nom, banque.nom) && Objects.equals(clients, banque.clients);
    }

}
