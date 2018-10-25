package com.address.address.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long id;

    @Column(name = "contact_telephone", nullable = false)
    @Size(max = 10)
    private String telephone;

    @Column(name = "contact_mail", nullable = false)
    @Size(max = 60)
    private String mail;

    public Contact() {
    }

    public Contact(@Size(max = 10) String telephone, @Size(max = 60) String mail) {
        this.telephone = telephone;
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
