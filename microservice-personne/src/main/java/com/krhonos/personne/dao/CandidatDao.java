package com.krhonos.personne.dao;

import com.krhonos.personne.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatDao extends JpaRepository<Candidat, Long> {

}
