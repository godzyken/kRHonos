package com.krhonos.calendar.model;

import javax.persistence.*;

@Entity
@Table(name="conge")
@DiscriminatorValue(value = "CNG")
public class Conge extends Absence {

    @Column(name="conges_validation")
    private String validation;

    @JoinColumn(name="periode_id")
    @ManyToOne
    private PeriodeConge periodeConge;


}
