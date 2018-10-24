package com.krhonos.salaried.model;

import javax.persistence.*;

@Entity
@Table(name = "doc_diplome")
public class Doc_Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doc_diplome_id")
    private long id;

    @Column(name = "doc_diplome_adresse")
    private String diplomeAdresse;

    public Doc_Diplome() {
    }

    public Doc_Diplome(String diplomeAdresse) {
        this.diplomeAdresse = diplomeAdresse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiplomeAdresse() {
        return diplomeAdresse;
    }

    public void setDiplomeAdresse(String diplomeAdresse) {
        this.diplomeAdresse = diplomeAdresse;
    }

    @Override
    public String toString() {
        return "Doc_Diplome{" +
                "id=" + id +
                ", diplomeAdresse='" + diplomeAdresse + '\'' +
                '}';
    }
}
