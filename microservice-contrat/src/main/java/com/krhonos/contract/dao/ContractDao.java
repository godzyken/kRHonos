package com.krhonos.contract.dao;

import com.krhonos.contract.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDao extends JpaRepository<Contrat, Long> {

}

