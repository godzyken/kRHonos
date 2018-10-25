package com.krhonos.calendrier.controller;

import com.krhonos.calendrier.model.Absence;
import com.krhonos.calendrier.dao.AbsenceDao;
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
public class AbsenceController {

    @Autowired
    AbsenceDao repository;

    @GetMapping("/absences")
    public List<Absence> getAllAbsences() {
        System.out.println("Toutes les absences...");

        List<Absence> absences = new ArrayList<>();
        repository.findAll().forEach(absences::add);

        return absences;
    }

    @PostMapping(value = "/absences/create")
    public Absence postAbsence(@RequestBody Absence absence) {
        Absence _absence = repository.save(new Absence(absence.getDateDebut(), absence.getDateFin(), absence.getDescription(), absence.getValeur(), absence.getContratId(), absence.getTypeAbsence()));
        return _absence;
    }

    @DeleteMapping("/absences/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable("id") long id) {
        System.out.println("Suppression de l'absence avec l'id : " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("L'absence a été supprimée", HttpStatus.OK);
    }

    @GetMapping(value = "absences/{id}")
    public ResponseEntity<Absence> findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/absences/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable("id") long id, @RequestBody Absence absence) {
        System.out.println("L'absence avec l'id " + id + " a été mis à jour...");

        Optional<Absence> absenceData = repository.findById(id);

        if(absenceData.isPresent()){
            Absence _absence = absenceData.get();
            _absence.setDateDebut(absence.getDateDebut());
            _absence.setDateFin(absence.getDateFin());
            _absence.setDescription(absence.getDescription());
            _absence.setValeur(absence.getValeur());
            _absence.setContratId(absence.getContratId());
            _absence.setTypeAbsence(absence.getTypeAbsence());
            return new ResponseEntity<>(repository.save(_absence), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
