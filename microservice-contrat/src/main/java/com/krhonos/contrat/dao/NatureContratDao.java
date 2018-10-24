package com.krhonos.contrat.dao;


import com.krhonos.contrat.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureContratDao extends JpaRepository<Contrat, Long> {

}

