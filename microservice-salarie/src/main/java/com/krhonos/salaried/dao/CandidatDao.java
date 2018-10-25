package com.krhonos.salaried.dao;

import com.krhonos.salaried.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatDao extends JpaRepository<Candidat, Long> {

}
