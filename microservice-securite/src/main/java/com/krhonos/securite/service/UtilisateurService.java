package com.krhonos.securite.service;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurService implements JpaRepositoriesAutoConfiguration {

  public List findAll() {
  }
}
