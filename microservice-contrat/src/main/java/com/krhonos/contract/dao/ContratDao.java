package com.krhonos.contract.dao;

import com.krhonos.contract.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratDao extends JpaRepository<Contrat, Long> {

}

