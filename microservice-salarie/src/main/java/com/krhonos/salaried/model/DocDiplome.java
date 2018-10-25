package com.krhonos.salaried.model;

import javax.persistence.*;

@Entity
@Table(name = "doc_diplome")
public class DocDiplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_diplome_id")
    private long id;

    @Column(name = "doc_diplome_adresse")
    private String diplomeAdresse;

    @OneToOne
    @JoinColumn(name = "doc_diplome_diplome")
    private Diplome diplome;

    public DocDiplome() {
    }

    public DocDiplome(String diplomeAdresse, Diplome diplome) {
        this.diplomeAdresse = diplomeAdresse;
        this.diplome = diplome;
    }

    public DocDiplome(String diplomeAdresse) {
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

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    @Override
    public String toString() {
        return "DocDiplome{" +
                "id=" + id +
                ", diplomeAdresse='" + diplomeAdresse + '\'' +
                '}';
    }
}
