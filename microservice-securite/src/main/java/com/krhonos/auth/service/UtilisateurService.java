package com.krhonos.auth.service;

import com.krhonos.auth.model.Utilisateur;

public interface UtilisateurService {

  void save(Utilisateur utilisateur);

  Utilisateur findByUtilisateurnom(String utilisateurnom);
}
