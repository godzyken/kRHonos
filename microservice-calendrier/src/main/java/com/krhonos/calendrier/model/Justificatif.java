package com.krhonos.calendrier.model;

import javax.persistence.*;

@Entity
@Table(name="justificatif")
public class Justificatif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="justificatif_id")
    private long id;

    @Column(name="justificatif_adresse", nullable = false)
    private String adresse;

    @JoinColumn(name="absence_id", nullable = false)
    @ManyToOne
    private Absence absence;

    public Justificatif() {
    }

    public Justificatif(String adresse, Absence absence) {
        this.adresse = adresse;
        this.absence = absence;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }

    @Override
    public String toString() {
        return "Justificatif{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", absence=" + absence +
                '}';
    }
}
