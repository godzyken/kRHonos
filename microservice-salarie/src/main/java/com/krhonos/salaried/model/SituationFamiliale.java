package com.krhonos.salaried.model;


import javax.persistence.*;

@Entity
@Table(name = "situation_familiale")
public class SituationFamiliale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fam_id")
    private long id;

    @Column(name = "fam_libelle")
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
