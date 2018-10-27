package com.krhonos.personne.model;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private long id;

    @Column(name = "document_rib")
    private String rib;

    @Column(name = "document_secu")
    private String secu;

    @OneToOne
    @JoinColumn(name = "salarie_id", nullable = false)
    private Salarie salarie;

    public Document() {
    }

    public Document(String rib, String secu, Salarie salarie) {
        this.rib = rib;
        this.secu = secu;
        this.salarie = salarie;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getSecu() {
        return secu;
    }

    public void setSecu(String secu) {
        this.secu = secu;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public long getId() {
        return id;
    }
}
