package com.krhonos.contrat.dao;


import com.krhonos.contrat.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratDao extends JpaRepository<Contrat, Long> {

}

