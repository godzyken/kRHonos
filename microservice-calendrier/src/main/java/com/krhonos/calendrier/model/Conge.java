package com.krhonos.calendrier.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="conge")
@PrimaryKeyJoinColumn(name = "absence_id")
public class Conge extends Absence {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name="validation_id", nullable = false)
    @ManyToOne
    private CongeValidation validation;

    @JoinColumn(name="periode_id", nullable = false)
    @ManyToOne
    private PeriodeConge periodeConge;

    public Conge() {
    }

    public Conge(CongeValidation validation, PeriodeConge periodeConge) {
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public Conge(LocalDateTime dateDebut, LocalDateTime dateFin, String description, float valeur, long contratId, TypeAbsence typeAbsence, CongeValidation validation, PeriodeConge periodeConge) {
        super(dateDebut, dateFin, description, valeur, contratId, typeAbsence);
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public CongeValidation getValidation() {
        return validation;
    }

    public void setValidation(CongeValidation validation) {
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
