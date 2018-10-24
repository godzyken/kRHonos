package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.dao.GrilleDao;
import com.krhonos.etablissement.model.Grille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GrilleController {

    @Autowired
    GrilleDao grilleDao;

    @GetMapping("/grilles")
    public List<Grille> getAllGrilles() {

        List<Grille> grilles = new ArrayList<>();
        grilleDao.findAll().forEach(grilles::add);

        return grilles;
    }

    @PostMapping(value = "/grilles/create")
    public Grille postGrille(@RequestBody Grille grille) {
        Grille _grille = grilleDao.save(new Grille(grille.getLibelle(), grille.getCoefficients()));
        return _grille;
    }

    @DeleteMapping("/grilles/{id}")
    public ResponseEntity<String> deleteGrille(@PathVariable("id") long id) {
        System.out.println("Suppression de la grilles avec l'id : $id...");

        grilleDao.deleteById(id);

        return new ResponseEntity<>("La grille a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "grilles/{id}")
    public ResponseEntity<Grille> findById(@PathVariable long id) {
        if(grilleDao.findById(id).isPresent()){
            return new ResponseEntity<>(grilleDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/grilles/{id}")
    public ResponseEntity<Grille> updateGrille(@PathVariable("id") long id, @RequestBody Grille grille) {
        System.out.println("La grille avec l'id $id a été mis à jour...");

        Optional<Grille> grilleData = grilleDao.findById(id);

        if(grilleData.isPresent()){
            Grille _grille = grilleData.get();
            _grille.setLibelle(grille.getLibelle());
            _grille.setCoefficients(grille.getCoefficients());
            return new ResponseEntity<>(grilleDao.save(_grille), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
