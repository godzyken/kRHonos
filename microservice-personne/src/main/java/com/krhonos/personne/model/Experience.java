package com.krhonos.personne.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_id")
    private long id;

    @Column(name = "experience_nom_entreprise")
    private String nomEntreprise;

    @Column(name = "experience_date_debut")
    private Date dateDebut;

    @Column(name = "experience_date_fin")
    private Date dateFin;

    @Column(name = "experience_descriptif")
    private String descriptif;

    @ManyToOne
    @JoinColumn(name = "experience_personne_id")
    private Personne personne;

    public Experience() {
    }

    public Experience(String nomEntreprise, Date dateDebut, Date dateFin, String descriptif, Personne personne) {
        this.nomEntreprise = nomEntreprise;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.descriptif = descriptif;
        this.personne = personne;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", nomEntreprise='" + nomEntreprise + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", descriptif='" + descriptif + '\'' +
                '}';
    }
}
