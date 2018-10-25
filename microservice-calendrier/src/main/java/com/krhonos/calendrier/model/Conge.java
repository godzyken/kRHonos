package com.krhonos.calendrier.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="conge")
@DiscriminatorValue(value = "CNG")
public class Conge extends Absence {

    @Column(name="conges_validation")
    @Size(max = 20)
    private String validation;

    @JoinColumn(name="periode_id", nullable = false)
    @ManyToOne
    private PeriodeConge periodeConge;

    public Conge() {
    }

    public Conge(String validation, PeriodeConge periodeConge) {
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public Conge(LocalDateTime dateDebut, LocalDateTime dateFin, String description, float valeur, String validation, PeriodeConge periodeConge) {
        super(dateDebut, dateFin, description, valeur);
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public Conge(long id, LocalDateTime dateDebut, LocalDateTime dateFin, String description, float valeur, String validation, PeriodeConge periodeConge) {
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
