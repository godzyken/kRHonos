package com.address.address.dao;

import com.address.address.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact, Long> {
}
