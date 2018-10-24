package com.krhonos.etablissement.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "taux_charges")
public class TauxCharges {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tx_charges_id")
    private long id;

    @Column(name = "tx_charges_libelle")
    private String libelle;

    @Column(name = "tx_charges_valeur")
    private float valeur;

    @Column(name = "tx_charges_date")
    private Date dateEffet;

    @Column(name = "tx_charges_statut")
    private String statut;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tauxChargesSet")
    private Set<Emploi> emplois = new HashSet<>();

    public TauxCharges() {
    }

    public TauxCharges(String libelle, float valeur, Date dateEffet, String statut, Set<Emploi> emplois) {
        this.libelle = libelle;
        this.valeur = valeur;
        this.dateEffet = dateEffet;
        this.statut = statut;
        this.emplois = emplois;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Set<Emploi> getEmplois() {
        return emplois;
    }

    public void setEmplois(Set<Emploi> emplois) {
        this.emplois = emplois;
    }
}
