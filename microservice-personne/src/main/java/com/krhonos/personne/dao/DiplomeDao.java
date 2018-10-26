package com.krhonos.salaried.dao;

import com.krhonos.salaried.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomeDao extends JpaRepository<Diplome, Long> {
}
