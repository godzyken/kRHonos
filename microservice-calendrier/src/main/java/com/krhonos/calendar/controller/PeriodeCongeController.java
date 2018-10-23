package com.krhonos.calendar.controller;

import com.krhonos.calendar.model.PeriodeConge;
import com.krhonos.calendar.repository.PeriodeCongeRepository;
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
public class PeriodeCongeController {

    @Autowired
    public PeriodeCongeRepository repository;

    @GetMapping("/periode_conge")
    public List<PeriodeConge> getAllPeriodeConges() {
        System.out.println("Toutes les periodes_conges...");

        List<PeriodeConge> periodeconges = new ArrayList<>();
        repository.findAll().forEach(periodeconges::add);

        return periodeconges;
    }

    @PostMapping(value = "/periode_conge/create")
    public PeriodeConge postPeriodeConge(@RequestBody PeriodeConge periodeconge) {
        PeriodeConge _periodeconge = repository.save(new PeriodeConge(periodeconge.getPeriodeDebut(), periodeconge.getPeriodeFin(), periodeconge.getAcquisition()));
        return _periodeconge;
    }

    @DeleteMapping("/periode_conge/{id}")
    public ResponseEntity<String> deletePeriodeConge(@PathVariable("id") long id) {
        System.out.println("Suppression du periodeconge avec l'id : $id...");

        repository.deleteById(id);

        return new ResponseEntity<>("La periode_conge a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "periode_conge/{id}")
    public ResponseEntity<PeriodeConge> findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/periode_conge/{id}")
    public ResponseEntity<PeriodeConge> updatePeriodeConge(@PathVariable("id") long id, @RequestBody PeriodeConge periodeconge) {
        System.out.println("La periode_conge avec l'id $id a été mis à jour...");

        Optional<PeriodeConge> periodecongeData = repository.findById(id);

        if(periodecongeData.isPresent()){
            PeriodeConge _periodeconge = periodecongeData.get();
            _periodeconge.setPeriodeDebut(periodeconge.getPeriodeDebut());
            _periodeconge.setPeriodeFin(periodeconge.getPeriodeFin());
            _periodeconge.setAcquisition(periodeconge.getAcquisition());
            return new ResponseEntity<>(repository.save(_periodeconge), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
