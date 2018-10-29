package com.krhonos.personne.controller;


import com.krhonos.personne.dao.CiviliteDao;
import com.krhonos.personne.model.Civilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CiviliteController {

    @Autowired
    CiviliteDao civiliteDao;

    //Find All
    @GetMapping(value = "/civilite")
    public List<Civilite> getAllCivilite() {
        List<Civilite> civilites = new ArrayList<>();
        civiliteDao.findAll().forEach(civilites::add);
        return civilites;
    }

    //Find By Id
    @GetMapping(value = "/civilite/{id}")
    public Civilite findById(@PathVariable long id) {

        if(civiliteDao.findById(id).isPresent()) {
        return civiliteDao.findById(id).get();
        }
        return null;
    }
}
