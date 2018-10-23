package com.krhonos.salaried.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "salarie")
public class Salarie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salarie_id")
    private long id;

    @Column(name = "salarie_num_secu")
    private String numSecu;

    @Column(name = "salarie_cle_secu")
    private int cleSecu;

    @Column(name = "salarie_date_naissance")
    private Date dateNaissance;

    @Column(name = "civilite_id")
    private int civilite;

    @ManyToOne
    @JoinColumn(name = "fam_id")
    private SituationFamiliale situationFam;

    public Salarie() {
    }

    public Salarie(String numSecu, int cleSecu, Date dateNaissance, int civilite, SituationFamiliale situationFam) {
        this.numSecu = numSecu;
        this.cleSecu = cleSecu;
        this.dateNaissance = dateNaissance;
        this.civilite = civilite;
        this.situationFam = situationFam;
    }

    public long getId() {
        return id;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public int getCleSecu() {
        return cleSecu;
    }

    public void setCleSecu(int cleSecu) {
        this.cleSecu = cleSecu;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getCivilite() {
        return civilite;
    }

    public void setCivilite(int civilite) {
        this.civilite = civilite;
    }

    public SituationFamiliale getSituationFam() {
        return situationFam;
    }

    public void setSituationFam(SituationFamiliale situationFam) {
        this.situationFam = situationFam;
    }
}
