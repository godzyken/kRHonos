package com.krhonos.calendar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="absence")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="ABS_TYPE", discriminatorType = DiscriminatorType.STRING, length = 3)
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="absence_id")
    private long id;

    @Column(name="absence_debut")
    private Date dateDebut;

    @Column(name="absence_fin")
    private Date dateFin;

    @Column(name="absence_desciption")
    private String description;

    @Column(name="absence_valeur")
    private float valeur;

    public Absence() {
    }

    public Absence(Date dateDebut, Date dateFin, String description, float valeur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.valeur = valeur;
    }

    public Absence(long id, Date dateDebut, Date dateFin, String description, float valeur) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.valeur = valeur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", description='" + description + '\'' +
                ", valeur=" + valeur +
                '}';
    }
}
