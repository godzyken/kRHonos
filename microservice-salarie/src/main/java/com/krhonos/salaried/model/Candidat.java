package com.krhonos.salaried.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat extends Personne {

    @Column(name = "candidat_date_dispo")
    private Date date_dispo;
}
