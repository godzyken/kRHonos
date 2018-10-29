package com.krhonos.contrat.model;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "nature_contrat")
public class NatureContrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nature_ctr_id")
    private long id;

    @Column(name = "nature_ctr_libelle", nullable = false, unique = true)
    @Size(max = 20)
    private String natureCtrLibelle;

    @Column(name = "nature_ctr_actif", nullable = false)
    private boolean natureCtrActif;

    public NatureContrat() {
    }

    public NatureContrat(String natureCtrLibelle, boolean natureCtrActif) {
        this.natureCtrLibelle = natureCtrLibelle;
        this.natureCtrActif = natureCtrActif;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNatureCtrLibelle() {
        return natureCtrLibelle;
    }

    public void setNatureCtrLibelle(String natureCtrLibelle) {
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





