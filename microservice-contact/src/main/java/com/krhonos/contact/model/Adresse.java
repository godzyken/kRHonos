package com.krhonos.contact.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresse_id")
    private long id;

    @Column(name = "adresse_latitude", precision = 10, scale = 8, nullable = false)
    private BigDecimal latitude;

    @Column(name = "adresse_longitude", precision = 11, scale = 8, nullable = false)
    private BigDecimal longitude;

    @Column(name = "adresse_numero", nullable = false)
    @Size(max = 5)
    private String numero;

    @Column(name = "adresse_complement", nullable = false)
    private String complement;

    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false, unique = true)
    private Contact contact;

    public Adresse() {
    }

    public Adresse(BigDecimal latitude, BigDecimal longitude, @Size(max = 5) String numero, String complement, Contact contact) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.numero = numero;
        this.complement = complement;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
