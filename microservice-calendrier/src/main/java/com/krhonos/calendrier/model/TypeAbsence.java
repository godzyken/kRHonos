package com.krhonos.calendrier.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="type_absence")
public class TypeAbsence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="type_abs_id")
    private long id;

    @Column(name="type_abs_libelle_court", nullable = false, length = 15, unique = true)
    private String libelleCourt;

    @Column(name="type_abs_libelle", nullable = false, length = 80, unique = true)
    private String libelleLong;

    @Column(name="type_abs_format", nullable = false, length = 1)
    private String format;

    public TypeAbsence() {
    }

    public TypeAbsence(String libelleCourt, String libelleLong, String format) {
        this.libelleCourt = libelleCourt;
        this.libelleLong = libelleLong;
        this.format = format;
    }

    public TypeAbsence(long id, String libelleCourt, String libelleLong, String format) {
        this.id = id;
        this.libelleCourt = libelleCourt;
        this.libelleLong = libelleLong;
        this.format = format;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelleCourt() {
        return libelleCourt;
    }

    public void setLibelleCourt(String libelleCourt) {
        this.libelleCourt = libelleCourt;
    }

    public String getLibelleLong() {
        return libelleLong;
    }

    public void setLibelleLong(String libelleLong) {
        this.libelleLong = libelleLong;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "TypeAbsence{" +
                "id=" + id +
                ", libelleCourt='" + libelleCourt + '\'' +
                ", libelleLong='" + libelleLong + '\'' +
                ", format=" + format +
                '}';
    }
}
