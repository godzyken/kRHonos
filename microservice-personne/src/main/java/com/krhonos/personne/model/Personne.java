package com.krhonos.personne.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "personne")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personne_id")
    private long id;

    @Column(name = "personne_nom", nullable = false)
    @Size(max = 70)
    private String nom;


    @Column(name = "personne_nom_naissance")
    @Size(max = 70)
    private String nomNaissance;

    @Column(name = "personne_prenom", nullable = false)
    @Size(max = 70)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "civilite_id", nullable = false)
    private Civilite civilite;

    public Personne() {
    }

    public Personne(String nom, String nomNaissance, String prenom) {
        this.nom = nom;
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomNaissance() {
        return nomNaissance;
    }

    public void setNomNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }
}
