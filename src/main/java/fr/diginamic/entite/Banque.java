package fr.diginamic.entite;

import jakarta.persistence.*;

@Entity
@Table(name="banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column (name = "NOM")
    private String nom;

    @OneToMany(mappedBy = "banques")
    private Client client;
    public Banque(){

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banque{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", client=").append(client);
        sb.append('}');
        return sb.toString();
    }


    public Banque(String nom) {
        this.nom = nom;
    }

    /**
     * Setter
     *
     * @param client client
     */


    public void setClient(Client client) {
        this.client = client;
    }
}
