package com.krhonos.personne.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "situation_familiale")
public class SituationFamiliale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fam_id", nullable = false)
    private long id;

    @Column(name = "fam_libelle", nullable = false)
    @Size(max = 20)
    private String libelle;

    public SituationFamiliale() {
    }

    public SituationFamiliale(String libelle) {
        this.libelle = libelle;
    }


    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "SituationFamiliale{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
