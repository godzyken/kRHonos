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

    @Column(name = "contact_id", nullable = false, unique = true)
    private long contactId;

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Personne() {
    }

    public Personne(@Size(max = 70) String nom,
                    @Size(max = 70) String nomNaissance,
                    @Size(max = 70) String prenom,
                    Civilite civilite,
                    long contactId) {
        this.nom = nom;
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
        this.civilite = civilite;
        this.contactId = contactId;
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

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
