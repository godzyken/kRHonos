package com.address.address.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long id;

    @Column(name = "contact_telephone")
    @Size(max = 10)
    private String telephone;

    @Column(name = "contact_mail")
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
