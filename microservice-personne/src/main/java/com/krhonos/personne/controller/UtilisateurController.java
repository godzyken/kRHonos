package com.krhonos.personne.controller;


import com.krhonos.personne.dao.UtilisateurDao;
import com.krhonos.personne.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtilisateurController {
    @Autowired
    UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur")
    public List<Utilisateur> getAllSalaried() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurDao.findAll().forEach(utilisateurs::add);

        return utilisateurs;
    }

    @GetMapping(value = "/utilisateur/{id}")
    public Utilisateur findById(@PathVariable long id) {

        if (utilisateurDao.findById(id).isPresent()) {
            return utilisateurDao.findById(id).get();
        }
        return null;
    }

    @PostMapping(value = "/utilisateur/create")
    public Utilisateur postUtilisateur(@RequestBody Utilisateur utilisateur) {

        return null;
    }
}
