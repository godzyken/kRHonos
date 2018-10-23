package com.krhonos.etablissement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grille")
public class Grille {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grille_id")
    private long id;

    @Column(name = "grille_libelle")
    @Size(max = 50)
    private String libelle;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "grille__coefficient",
            joinColumns = { @JoinColumn(name = "grille_id") },
            inverseJoinColumns = { @JoinColumn(name = "coefficient_id") })
    private Set<Coefficient> coefficients = new HashSet<>();

    public Grille() {
    }

    public Grille(@Size(max = 50) String libelle, Set<Coefficient> coefficients) {
        this.libelle = libelle;
        this.coefficients = coefficients;
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

    public Set<Coefficient> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Set<Coefficient> coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public String toString() {
        return "Grille{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", coefficients=" + coefficients +
                '}';
    }
}
