package com.krhonos.salaried.model;

import javax.persistence.*;

@Entity
@Table(name = "personne")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personne_id")
    private long id;

    @Column(name = "personne_nom")
    private String nom;


    @Column(name = "personne_nom_naissance", nullable = true)
    private String nomNaissance;

    @Column(name = "personne_prenom")
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "civilite_id")
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
