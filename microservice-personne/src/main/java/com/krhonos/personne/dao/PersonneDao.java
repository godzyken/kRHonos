package com.krhonos.personne.dao;

import com.krhonos.personne.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneDao extends JpaRepository<Personne, Long> {
}
