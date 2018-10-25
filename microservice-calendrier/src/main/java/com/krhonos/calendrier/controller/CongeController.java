package com.krhonos.calendrier.controller;

import com.krhonos.calendrier.model.Conge;
import com.krhonos.calendrier.dao.CongeDao;
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
public class CongeController {
    @Autowired
    CongeDao repository;

    @GetMapping("/conges")
    public List<Conge> getAllConges() {
        System.out.println("Toutes les conges...");

        List<Conge> conges = new ArrayList<>();
        repository.findAll().forEach(conges::add);

        return conges;
    }

    @PostMapping(value = "/conges/create")
    public Conge postConge(@RequestBody Conge conge) {
        Conge _conge = repository.save(new Conge(
                conge.getDateDebut(),
                conge.getDateFin(),
                conge.getDescription(),
                conge.getValeur(),
                conge.getContratId(),
                conge.getTypeAbsence(),
                conge.getValidation(),
                conge.getPeriodeConge()));
        return _conge;
    }

    @DeleteMapping("/conges/{id}")
    public ResponseEntity<String> deleteConge(@PathVariable("id") long id) {
        System.out.println("Suppression du congé avec l'id : " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Le congé a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "conges/{id}")
    public ResponseEntity<Conge> findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/conges/{id}")
    public ResponseEntity<Conge> updateConge(@PathVariable("id") long id, @RequestBody Conge conge) {
        System.out.println("Le congé avec l'id " + id + " a été mis à jour...");

        Optional<Conge> congeData = repository.findById(id);

        if(congeData.isPresent()){
            Conge _conge = congeData.get();
            _conge.setDateDebut(conge.getDateDebut());
            _conge.setDateFin(conge.getDateFin());
            _conge.setDescription(conge.getDescription());
            _conge.setValeur(conge.getValeur());
            _conge.setContratId(conge.getContratId());
            _conge.setTypeAbsence(conge.getTypeAbsence());
            _conge.setValidation(conge.getValidation());
            _conge.setPeriodeConge(conge.getPeriodeConge());
            return new ResponseEntity<>(repository.save(_conge), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
