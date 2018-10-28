package com.krhonos.calendrier.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="conge_validation")
public class CongeValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="validation_id")
    private long id;

    @Column(name="validation_status")
    @Size(max = 7)
    private String status;

    public CongeValidation() {
    }

    public CongeValidation(@Size(max = 7) String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
