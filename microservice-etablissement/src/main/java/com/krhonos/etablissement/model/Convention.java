package com.krhonos.etablissement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "convention")
public class Convention {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "convention_id")
    private long id;

    @Column(name = "convention_libelle", nullable = false)
    @Size(max = 150)
    private String libelle;

    @Column(name = "convention_valeur_point", nullable = false, columnDefinition = "FLOAT(4,2)")
    private float valeurPoint;

    public Convention() {
    }

    public Convention(@Size(max = 150) String libelle, float valeurPoint) {
        this.libelle = libelle;
        this.valeurPoint = valeurPoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getValeurPoint() {
        return valeurPoint;
    }

    public void setValeurPoint(float valeurPoint) {
        this.valeurPoint = valeurPoint;
    }

    @Override
    public String toString() {
        return "Convention{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", valeurPoint=" + valeurPoint +
                '}';
    }
}
