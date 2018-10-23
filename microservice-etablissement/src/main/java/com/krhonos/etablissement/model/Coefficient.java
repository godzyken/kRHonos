package com.krhonos.etablissement.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coefficient")
public class Coefficient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coefficient_id")
    private long id;

    @Column(name = "valeur")
    private float valeur;

    @Column(name = "coefficient_anciennete")
    private int anciennete;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "coefficient")
    private Set<Grille> grilles = new HashSet<>();

    public Coefficient() {
    }

    public Coefficient(float valeur, int anciennete) {
        this.valeur = valeur;
        this.anciennete = anciennete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    @Override
    public String toString() {
        return "Coefficient{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", anciennete=" + anciennete +
                '}';
    }
}
