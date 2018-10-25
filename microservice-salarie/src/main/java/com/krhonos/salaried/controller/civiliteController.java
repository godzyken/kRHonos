package com.krhonos.salaried.controller;

import com.krhonos.salaried.dao.CiviliteDao;
import com.krhonos.salaried.model.Civilite;
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

    @GetMapping("/civilite")
    public List<Civilite> getAllSalaried() {
        System.out.println("Get all salaried...");

        List<Civilite> civilites = new ArrayList<>();
        civiliteDao.findAll().forEach(civilites::add);

        return civilites;
    }

    @PostMapping(value = "/civilite/create")
    public Civilite postSalaried(@RequestBody Civilite civilite) {
        Civilite _civilite =
                civiliteDao.save(
                        new Civilite(
                                civilite.getIdentifiant(),
                                civilite.getSexe()

                        )
                );
        return _civilite;
    }

    @GetMapping(value = "civilite/{id}")
    public Civilite findById(@PathVariable long id) {

        if (civiliteDao.findById(id).isPresent()) {
            return civiliteDao.findById(id).get();
        }
        return null;
    }

}
