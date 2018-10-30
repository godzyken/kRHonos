package com.krhonos.personne.controller;

import com.krhonos.personne.dao.CandidatDao;
import com.krhonos.personne.model.Candidat;
import com.krhonos.personne.service.ModelMapperService;
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
    @Autowired
    ModelMapperService modelMapperService;


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

        if (candidatDao.findById(id).isPresent()) {
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
                                candidat.getDateDispo(),
                                candidat.getCivilite(),
                                candidat.getContactId()
                        ));
        return _candidat;
    }


    @PutMapping(value = "/candidat/update/{id}")
    public Candidat updateCandidat(@PathVariable long id, @RequestBody Candidat candidat) {
        Candidat _candidat = candidatDao.findById(id).get();
        if (_candidat != null) {
            modelMapperService.map(candidat, _candidat);
            candidatDao.save(_candidat);
        }
        return _candidat;
    }

    @DeleteMapping(value = "/candidat/delete/{id}")
    public void deleteCandidat(@PathVariable long id){
        candidatDao.deleteById(id);
    }
}
