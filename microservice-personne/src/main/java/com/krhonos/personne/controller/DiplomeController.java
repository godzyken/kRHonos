package com.krhonos.personne.controller;

import com.krhonos.personne.dao.DiplomeDao;
import com.krhonos.personne.model.Diplome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DiplomeController {
    @Autowired
    DiplomeDao diplomeDao;


    //Find All
    @GetMapping(value = "/diplome")
    public List<Diplome> getAllDiplome() {
        List<Diplome> diplomes = new ArrayList<>();
        diplomeDao.findAll().forEach(diplomes::add);

        return diplomes;
    }

    //Find By ID
    @GetMapping(value = "/diplome/{id}")
    public Diplome findById(@PathVariable long id) {

        if (diplomeDao.findById(id).isPresent()) {
            return diplomeDao.findById(id).get();
        }
        return null;
    }

    @PostMapping(value = "/diplome/create")
    public Diplome postDiplome(@RequestBody Diplome diplome) {
        Diplome _diplome =
                diplomeDao.save(
                        new Diplome(
                                diplome.getLibelle(),
                                diplome.isObtention(),
                                diplome.getAnneeObtention(),
                                diplome.getSalarie()
                        )
                );
        return _diplome;
    }
}
