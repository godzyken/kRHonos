package com.krhonos.calendar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="absence")
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="absence_id")
    private long id;

    @Column(name="absence_debut")
    private Date dateDebut;

    @Column(name="absence_fin")
    private Date dateFin;

    @Column(name="absence_desciption")
    private String description;

    @Column(name="absence_valorisation")
    

}
