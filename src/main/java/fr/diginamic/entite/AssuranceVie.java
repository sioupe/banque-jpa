package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table (name = "assurance_vie")
public class AssuranceVie {
    @Column(name = "date_fin")
    private LocalDate dateFin;

}
