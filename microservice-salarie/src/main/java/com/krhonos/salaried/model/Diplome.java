package com.krhonos.salaried.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "diplome")
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "diplome_libelle")
    private String libelle;

    @Column(name = "diplome_obtention")
    private boolean obtention;

    @Column(name = "diplome_annee_obtention")
    private Date anneeObtention;

    public Diplome() {
    }

    public Diplome(String libelle, boolean obtention, Date anneeObtention) {
        this.libelle = libelle;
        this.obtention = obtention;
        this.anneeObtention = anneeObtention;
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

    public boolean isObtention() {
        return obtention;
    }

    public void setObtention(boolean obtention) {
        this.obtention = obtention;
    }

    public Date getAnneeObtention() {
        return anneeObtention;
    }

    public void setAnneeObtention(Date anneeObtention) {
        this.anneeObtention = anneeObtention;
    }

    @Override
    public String toString() {
        return "Diplome{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", obtention=" + obtention +
                ", anneeObtention=" + anneeObtention +
                '}';
    }
}
