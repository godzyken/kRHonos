package com.krhonos.personne.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salarie")
public class Salarie extends Personne {

    @Column(name = "salarie_num_secu")
    private String numSecu;

    @Column(name = "salarie_cle_secu")
    private int cleSecu;

    @Column(name = "salarie_date_naissance")
    private Date dateNaissance;

    @ManyToOne
    @JoinColumn(name = "fam_id")
    private SituationFamiliale situationFam;

    public Salarie() {
    }

    public Salarie(String nom, String nomNaissance, String prenom, String numSecu, int cleSecu, Date dateNaissance, SituationFamiliale situationFam) {
        super(nom, nomNaissance, prenom);
        this.numSecu = numSecu;
        this.cleSecu = cleSecu;
        this.dateNaissance = dateNaissance;
        this.situationFam = situationFam;
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

    public SituationFamiliale getSituationFam() {
        return situationFam;
    }

    public void setSituationFam(SituationFamiliale situationFam) {
        this.situationFam = situationFam;
    }
}
