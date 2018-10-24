package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.dao.EmploiDao;
import com.krhonos.etablissement.model.Emploi;
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
public class EmploiController {
    @Autowired
    public EmploiDao emploiDao;

    @GetMapping("/emplois")
    public List<Emploi> getAllEmplois() {
        System.out.println("Tous les contrats_planning...");

        List<Emploi> emplois = new ArrayList<>();
        emploiDao.findAll().forEach(emplois::add);

        return emplois;
    }

    @PostMapping(value = "/emplois/create")
    public Emploi postEmploi(@RequestBody Emploi emploi) {
        Emploi _emploi = emploiDao.save(new Emploi(emploi.getLibelle(), emploi.isCadre(), emploi.getConvention(), emploi.getGrille(), emploi.getTauxCharge()));
        return _emploi;
    }

    @DeleteMapping("/emplois/{id}")
    public ResponseEntity<String> deleteEmploi(@PathVariable("id") long id) {
        System.out.println("Suppression du emplois avec l'id : $id...");

        emploiDao.deleteById(id);

        return new ResponseEntity<>("Le emplois a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "emplois/{id}")
    public ResponseEntity<Emploi> findById(@PathVariable long id) {
        if(emploiDao.findById(id).isPresent()){
            return new ResponseEntity<>(emploiDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/emplois/{id}")
    public ResponseEntity<Emploi> updateEmploi(@PathVariable("id") long id, @RequestBody Emploi emploi) {
        System.out.println("L'emploi avec l'id $id a été mis à jour...");

        Optional<Emploi> emploiData = emploiDao.findById(id);

        if(emploiData.isPresent()){
            Emploi _emploi = emploiData.get();
            _emploi.setLibelle(emploi.getLibelle());
            _emploi.setCadre(emploi.isCadre());
            _emploi.setConvention(emploi.getConvention());
            _emploi.setGrille(emploi.getGrille());
            _emploi.setTauxCharge(emploi.getTauxCharge());
            return new ResponseEntity<>(emploiDao.save(_emploi), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
