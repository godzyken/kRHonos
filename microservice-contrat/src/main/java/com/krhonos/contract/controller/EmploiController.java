package com.krhonos.contract.controller;

import com.krhonos.contract.model.Emploi;
import com.krhonos.contract.dao.EmploiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmploiController {

    @Autowired
    EmploiDao repository;

    @GetMapping("/emplois")
    public List<Emploi> getAllEmplois() {
        System.out.println("Liste de tous les emplois");

        List<Emploi> emplois = new ArrayList<>();
        repository.findAll().forEach(emplois::add);
        return emplois;
    }

    @GetMapping("/emplois/id/{id}")
    public Emploi findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }

        return null;
    }
}