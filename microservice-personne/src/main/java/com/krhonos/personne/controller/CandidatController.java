package com.krhonos.personne.controller;

import com.krhonos.personne.model.Candidat;
import com.krhonos.personne.dao.CandidatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CandidatController {

    @Autowired
    CandidatDao candidatDao;


    //FindAll
    @GetMapping("/candidats")
    public List<Candidat> getCandidatList() {
        List<Candidat> candidats = new ArrayList<>();
        candidatDao.findAll().forEach(candidats::add);

        return candidats;
    }

    //FindById
    @GetMapping(value = "candidat/{id}")
    public Candidat findById(@PathVariable long id) {

        if(candidatDao.findById(id).isPresent()) {
            return candidatDao.findById(id).get();
        }
        return null;
    }


    //create
    @PostMapping(value = "/candidat/create")
    public Candidat postCandidat(@RequestBody Candidat candidat) {
        Candidat _candidat =
                candidatDao.save(
                        new Candidat(
                                candidat.getNom(),
                                candidat.getNomNaissance(),
                                candidat.getPrenom(),
                                candidat.getDate_dispo(),
                                candidat.getCivilite(),
                                candidat.getContactId()
                                ));
        return _candidat;
    }
}
