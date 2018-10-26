package com.krhonos.salaried.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat extends Personne {

    @Column(name = "candidat_date_dispo")
    private Date date_dispo;

    public Candidat() {
        super();
    }

    public Candidat(String nom, String nomNaissance, String prenom, Date date_dispo) {
        super(nom, nomNaissance, prenom);
        this.date_dispo = date_dispo;
    }

    public Date getDate_dispo() {
        return date_dispo;
    }

    public void setDate_dispo(Date date_dispo) {
        this.date_dispo = date_dispo;
    }
}
