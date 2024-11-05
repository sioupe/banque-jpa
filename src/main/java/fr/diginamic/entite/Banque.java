package fr.diginamic.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="banque")
public class Banque {
    private String nom;
}
