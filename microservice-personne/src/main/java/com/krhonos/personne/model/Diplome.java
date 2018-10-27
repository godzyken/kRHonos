package com.krhonos.personne.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "diplome")
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diplome_id")
    private long id;

    @Column(name = "diplome_libelle")
    private String libelle;

    @Column(name = "diplome_obtention")
    private boolean obtention;

    @Column(name = "diplome_annee_obtention")
    private Date anneeObtention;

    @ManyToOne
    @JoinColumn(name = "diplome_salarie")
    private Salarie salarie;

    public Diplome() {
    }

    public Diplome(String libelle, boolean obtention, Date anneeObtention, Salarie salarie) {
        this.libelle = libelle;
        this.obtention = obtention;
        this.anneeObtention = anneeObtention;
        this.salarie = salarie;
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

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
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
