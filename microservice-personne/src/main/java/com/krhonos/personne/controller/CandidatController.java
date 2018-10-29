package com.krhonos.personne.controller;

import com.krhonos.personne.model.Candidat;
import com.krhonos.personne.dao.CandidatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CandidatController {

    @Autowired
    CandidatDao candidatDao;

    @GetMapping("/candidats")
    public List<Candidat> getCandidatList() {
        List<Candidat> candidats = new ArrayList<>();
        candidatDao.findAll().forEach(candidats::add);

        return candidats;
    }
}
