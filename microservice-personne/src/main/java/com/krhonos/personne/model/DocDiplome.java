package com.krhonos.personne.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "doc_diplome")
public class DocDiplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_diplome_id")
    private long id;

    @Column(name = "doc_diplome_adresse", nullable = false)
    private String diplomeAdresse;

    @OneToOne
    @JoinColumn(name = "diplome_id", nullable = false, unique = true)
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
