package com.krhonos.salaried.dao;

import com.krhonos.salaried.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDao extends JpaRepository<Document, Long> {

}
