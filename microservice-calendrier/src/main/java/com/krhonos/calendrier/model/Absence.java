package com.krhonos.calendrier.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="absence")
@Inheritance(strategy = InheritanceType.JOINED)
public class Absence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="absence_id")
    private long id;

    @Column(name="absence_debut", nullable = false)
    private LocalDateTime dateDebut;

    @Column(name="absence_fin", nullable = false)
    private LocalDateTime dateFin;

    @Lob
    @Column(name="absence_desciption")
    private String description;

    @Column(name="absence_valeur", nullable = false, length = 5, precision = 4, scale = 1)
    private BigDecimal valeur;

    @Column(name="contrat_id", nullable = false)
    private long contratId;

    @JoinColumn(name="type_abs_id", nullable = false)
    @ManyToOne
    private TypeAbsence typeAbsence;

    public Absence() {
    }

    public Absence(LocalDateTime dateDebut, LocalDateTime dateFin, String description, BigDecimal valeur, long contratId, TypeAbsence typeAbsence) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.valeur = valeur;
        this.contratId = contratId;
        this.typeAbsence = typeAbsence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    public long getContratId() {
        return contratId;
    }

    public void setContratId(long contratId) {
        this.contratId = contratId;
    }

    public TypeAbsence getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(TypeAbsence typeAbsence) {
        this.typeAbsence = typeAbsence;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", description='" + description + '\'' +
                ", valeur=" + valeur +
                ", contratId=" + contratId +
                ", typeAbsence=" + typeAbsence +
                '}';
    }
}
