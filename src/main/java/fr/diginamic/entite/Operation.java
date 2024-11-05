package fr.diginamic.entite;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
public abstract class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "MONTANT")
    private double montant;
    @Column(name = "MOTIF")
    private String motif;

    @OneToMany(mappedBy = "operations")
    private Compte compte;

    public Operation(){

    }
    public Operation(LocalDateTime date, String motif, double montant) {
        this.date = date;
        this.motif = motif;
        this.montant = montant;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        sb.append("id= ").append(id);
        sb.append(", date= ").append(date);
        sb.append(", montant= ").append(montant);
        sb.append(", motif= '").append(motif).append('\'');
        sb.append(", compte= ").append(compte);
        sb.append('}');
        return sb.toString();
    }
}
