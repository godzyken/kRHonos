package com.krhonos.contrat.model;

import javax.persistence.*;


@Entity
@Table(name = "nature_contrat")
public class NatureContrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nature_ctr_id")
    private long id;

    @Column(name = "nature_ctr_libelle")
    private int natureCtrLibelle;

    @Column(name = "nature_ctr_actif")
    private boolean natureCtrActif;

    public NatureContrat() {
    }

    public NatureContrat(int natureCtrLibelle, boolean natureCtrActif) {
        this.natureCtrLibelle = natureCtrLibelle;
        this.natureCtrActif = natureCtrActif;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNatureCtrLibelle() {
        return natureCtrLibelle;
    }

    public void setNatureCtrLibelle(int natureCtrLibelle) {
        this.natureCtrLibelle = natureCtrLibelle;
    }

    public boolean isNatureCtrActif() {
        return natureCtrActif;
    }

    public void setNatureCtrActif(boolean natureCtrActif) {
        this.natureCtrActif = natureCtrActif;
    }

    @Override
    public String toString() {
        return "NatureContrat{" +
                "id=" + id +
                ", natureCtrLibelle=" + natureCtrLibelle +
                ", natureCtrActif=" + natureCtrActif +
                '}';
    }
}
