package com.krhonos.contrat.dao;


import com.krhonos.contrat.model.Contrat;
import com.krhonos.contrat.model.NatureContrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureContratDao extends JpaRepository<NatureContrat, Long> {

}

