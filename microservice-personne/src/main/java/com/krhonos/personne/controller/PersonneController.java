package com.krhonos.personne.controller;

import com.krhonos.personne.dao.PersonneDao;
import com.krhonos.personne.model.Personne;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PersonneController {

    @Autowired
    PersonneDao personneDao;

    @GetMapping("/personne")
    public List<Personne> getAllSalaried() {
        List<Personne> personnes = new ArrayList<>();
        personneDao.findAll().forEach(personnes::add);

        return personnes;
    }

    @GetMapping(value = "/personne/{id}")
    public Personne findById(@PathVariable long id) {

        if (personneDao.findById(id).isPresent()) {
            return personneDao.findById(id).get();
        }
        return null;
    }

    @PostMapping(value = "/personne/create")
    public Personne postPersonne(@RequestBody Personne personne) {
        Personne _personne =
                personneDao.save(
                        new Personne(
                            personne.getNom(),
                            personne.getNomNaissance(),
                            personne.getPrenom(),
                            personne.getCivilite(),
                            personne.getContactId()
                        )
                );
        return _personne;
    }
}
