package com.krhonos.securite.controller;

import com.krhonos.securite.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UtilisateurController {

  @Autowired
  private UtilisateurService utilisateurService;

  @RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
  public List listUtilisateur() {
    return utilisateurService.findAll();
  }

}
