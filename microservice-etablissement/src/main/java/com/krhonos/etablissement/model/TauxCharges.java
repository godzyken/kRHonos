package com.krhonos.etablissement.model;

import javax.persistence.*;

@Entity
@Table(name = "taux_charges")
public class TauxCharges {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tx_charges_id")
    private long id;

    
}
