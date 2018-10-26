package com.krhonos.contact.dao;

import com.krhonos.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact, Long> {
}
