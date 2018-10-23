package com.krhonos.salaried.model;

import javax.persistence.*;

@Entity
@Table(name = "personne")
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
}
