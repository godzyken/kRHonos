package com.krhonos.personne.dao;

import com.krhonos.personne.model.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarieDao extends JpaRepository<Salarie, Long> {
}
