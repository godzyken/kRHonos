package com.krhonos.salaried.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat {
    @Column(name = "candidat_date_dispo")
    private Date date_dispo;
}
