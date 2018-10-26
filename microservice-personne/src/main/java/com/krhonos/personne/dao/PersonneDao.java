package com.krhonos.salaried.dao;

import com.krhonos.salaried.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneDao extends JpaRepository<Personne, Long> {
}
