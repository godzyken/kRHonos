package com.krhonos.salaried.controller;

import com.krhonos.salaried.model.SituationFamiliale;
import com.krhonos.salaried.repository.SituationFamilialeRepository;
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
public class situationFamilialeController {
    @Autowired
    SituationFamilialeRepository repository;

    @GetMapping("/familySituations")
    public List<SituationFamiliale> getAllfamilySituation() {
        List<SituationFamiliale> situationFamilialeList = new ArrayList<>();
        repository.findAll().forEach(situationFamilialeList::add);
        return situationFamilialeList;
    }
}
