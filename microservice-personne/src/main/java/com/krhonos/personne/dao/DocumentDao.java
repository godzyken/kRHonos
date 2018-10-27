package com.krhonos.personne.dao;

import com.krhonos.personne.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDao extends JpaRepository<Document, Long> {

}
