package com.krhonos.calendrier.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="periode_conges")
public class PeriodeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="periode_id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name="periode_debut", nullable = false)
    private Date periodeDebut;

    @Temporal(TemporalType.DATE)
    @Column(name="periode_fin", nullable = false)
    private Date periodeFin;

    @Column(name="periode_acquisition", nullable = false, columnDefinition = "INT(2)")
    private int acquisition;

    @OneToMany(mappedBy = "periodeConge")
    private Collection<Conge> conges;

    public PeriodeConge() {
    }

    public PeriodeConge(Date periodeDebut, Date periodeFin, int acquisition) {
        this.periodeDebut = periodeDebut;
        this.periodeFin = periodeFin;
        this.acquisition = acquisition;
    }

    public PeriodeConge(long id, Date periodeDebut, Date periodeFin, int acquisition) {
        this.id = id;
        this.periodeDebut = periodeDebut;
        this.periodeFin = periodeFin;
        this.acquisition = acquisition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPeriodeDebut() {
        return periodeDebut;
    }

    public void setPeriodeDebut(Date periodeDebut) {
        this.periodeDebut = periodeDebut;
    }

    public Date getPeriodeFin() {
        return periodeFin;
    }

    public void setPeriodeFin(Date periodeFin) {
        this.periodeFin = periodeFin;
    }

    public int getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(int acquisition) {
        this.acquisition = acquisition;
    }

    @Override
    public String toString() {
        return "PeriodeConge{" +
                "id=" + id +
                ", periodeDebut=" + periodeDebut +
                ", periodeFin=" + periodeFin +
                ", acquisition=" + acquisition +
                '}';
    }
}
