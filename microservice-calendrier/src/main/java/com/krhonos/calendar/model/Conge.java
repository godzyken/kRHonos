package com.krhonos.calendar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="conge")
@DiscriminatorValue(value = "CNG")
public class Conge extends Absence {

    @Column(name="conges_validation")
    private String validation;

    @JoinColumn(name="periode_id")
    @ManyToOne
    private PeriodeConge periodeConge;

    public Conge() {
    }

    public Conge(String validation, PeriodeConge periodeConge) {
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public Conge(Date dateDebut, Date dateFin, String description, float valeur, String validation, PeriodeConge periodeConge) {
        super(dateDebut, dateFin, description, valeur);
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public Conge(long id, Date dateDebut, Date dateFin, String description, float valeur, String validation, PeriodeConge periodeConge) {
        super(id, dateDebut, dateFin, description, valeur);
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public PeriodeConge getPeriodeConge() {
        return periodeConge;
    }

    public void setPeriodeConge(PeriodeConge periodeConge) {
        this.periodeConge = periodeConge;
    }

    @Override
    public String toString() {
        return "Conge{" +
                "validation='" + validation + '\'' +
                ", periodeConge=" + periodeConge +
                '}';
    }
}
