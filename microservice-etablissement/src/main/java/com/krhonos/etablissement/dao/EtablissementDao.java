package com.krhonos.etablissement.dao;

import com.krhonos.etablissement.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementDao extends JpaRepository<Etablissement, Long> {
}
