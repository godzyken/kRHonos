package com.krhonos.calendrier.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name="conge")
@PrimaryKeyJoinColumn(name = "absence_id")
public class Conge extends Absence {

    private static final long serialVersionUID = 1L;

    @Column(name="conges_validation", nullable = false)
    @Size(max = 20)
    private String validation;

    @JoinColumn(name="periode_id", nullable = false)
    @ManyToOne
    private PeriodeConge periodeConge;

    public Conge() {
    }

    public Conge(@Size(max = 20) String validation, PeriodeConge periodeConge) {
        this.validation = validation;
        this.periodeConge = periodeConge;
    }

    public Conge(LocalDateTime dateDebut, LocalDateTime dateFin, String description, float valeur, long contratId, TypeAbsence typeAbsence, @Size(max = 20) String validation, PeriodeConge periodeConge) {
        super(dateDebut, dateFin, description, valeur, contratId, typeAbsence);
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
