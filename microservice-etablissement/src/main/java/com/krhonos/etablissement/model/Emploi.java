package com.krhonos.etablissement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "emploi")
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emploi_id")
    private long id;

    @Column(name = "emploi_libelle")
    @Size(max = 70)
    private String libelle;

    @Column(name = "emploi_cadre")
    private boolean cadre;

    @JoinColumn(name="convention_id")
    @ManyToOne
    private Convention convention;

    @JoinColumn(name="grille_id")
    @ManyToOne
    private Grille grille;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "emploi__taux_charges",
            joinColumns = { @JoinColumn(name = "emploi_id") },
            inverseJoinColumns = { @JoinColumn(name = "tx_charges_id") })
    private Set<TauxCharges> tauxChargesSet = new HashSet<>();

    public Emploi() {
    }

    public Emploi(@Size(max = 70) String libelle, boolean cadre, Convention convention, Grille grille, Set<TauxCharges> tauxChargesSet) {
        this.libelle = libelle;
        this.cadre = cadre;
        this.convention = convention;
        this.grille = grille;
        this.tauxChargesSet = tauxChargesSet;
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

    public boolean isCadre() {
        return cadre;
    }

    public void setCadre(boolean cadre) {
        this.cadre = cadre;
    }

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Set<TauxCharges> getTauxChargesSet() {
        return tauxChargesSet;
    }

    public void setTauxChargesSet(Set<TauxCharges> tauxChargesSet) {
        this.tauxChargesSet = tauxChargesSet;
    }
}
