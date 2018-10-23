package com.krhonos.salaried.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidat_id")
    private long id;

    @Column(name = "candidat_date_dispo")
    private Date date_dispo;
}
