package com.address.address.dao;

import com.address.address.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseDao extends JpaRepository<Adresse, Long> {
}
