package com.krhonos.salaried.controller;

import com.krhonos.salaried.model.Candidat;
import com.krhonos.salaried.repository.CandidatRepository;
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
public class candidatController {

    @Autowired
    CandidatRepository repository;

    @GetMapping("/candidats")
    public List<Candidat> getCandidatList() {
        List<Candidat> candidats = new ArrayList<>();
        repository.findAll().forEach(candidats::add);

        return candidats;
    }
}
