package com.krhonos.etablissement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "taux_charge")
public class TauxCharge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tx_charge_id")
    private long id;

    @Column(name = "tx_charge_libelle", nullable = false)
    @Size(max = 50)
    private String libelle;

    @Column(name = "tx_charge_valeur", nullable = false, columnDefinition = "FLOAT(5,3)")
    private float valeur;

    @Column(name = "tx_charge_date", nullable = false, columnDefinition = "DATE")
    private Date dateEffet;

    @Column(name = "tx_charge_statut", nullable = false)
    @Size(max = 10)
    private String statut;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tauxCharge")
    private Set<Emploi> emplois = new HashSet<>();

    public TauxCharge() {
    }

    public TauxCharge(String libelle, float valeur, Date dateEffet, String statut, Set<Emploi> emplois) {
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
