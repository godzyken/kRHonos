package com.krhonos.personne.controller;

import com.krhonos.personne.dao.PersonneDao;
import com.krhonos.personne.model.Experience;
import com.krhonos.personne.model.Personne;
import com.krhonos.personne.service.ModelMapperService;
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
    @Autowired
    ModelMapperService modelMapperService;

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

    @PutMapping(value = "/personne/update/{id}")
    public Personne updatePersonne(@PathVariable long id, @RequestBody Personne personne) {
        Personne _personne = personneDao.findById(id).get();
        if (_personne != null) {
            modelMapperService.map(personne, _personne);
            personneDao.save(_personne);
        }
        return _personne;
    }

    @DeleteMapping(value = "/personne/delete/{id}")
    public void deletePersonne(@PathVariable long id) {
        personneDao.deleteById(id);
    }
}
