package com.krhonos.calendar.model;

import javax.persistence.*;

@Entity
@Table(name="type_absence")
public class TypeAbsence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="type_abs_id")
    private long id;

    @Column(name="type_abs_libelle_court")
    private String libelleCourt;

    @Column(name="type_abs_libelle")
    private String libelleLong;

    @Column(name="type_abs_format")
    private FormatAbsence format;

    public TypeAbsence() {
    }

    public TypeAbsence(long id, String libelleCourt, String libelleLong, FormatAbsence format) {
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

    public FormatAbsence getFormat() {
        return format;
    }

    public void setFormat(FormatAbsence format) {
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
