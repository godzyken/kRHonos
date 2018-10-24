package com.krhonos.calendar.controller;

import com.krhonos.calendar.model.Justificatif;
import com.krhonos.calendar.dao.JustificatifDao;
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
public class JustificatifController {

    @Autowired
    public JustificatifDao repository;

    @GetMapping("/justificatif")
    public List<Justificatif> getAllJustificatifs() {
        System.out.println("Tous les justificatifs...");

        List<Justificatif> justificatifs = new ArrayList<>();
        repository.findAll().forEach(justificatifs::add);

        return justificatifs;
    }

    @PostMapping(value = "/justificatif/create")
    public Justificatif postJustificatif(@RequestBody Justificatif justificatif) {
        Justificatif _justificatif = repository.save(new Justificatif(justificatif.getAdresse(), justificatif.getAbsence()));
        return _justificatif;
    }

    @DeleteMapping("/justificatif/{id}")
    public ResponseEntity<String> deleteJustificatif(@PathVariable("id") long id) {
        System.out.println("Suppression du justificatif avec l'id : $id...");

        repository.deleteById(id);

        return new ResponseEntity<>("Le justificatif a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "justificatif/{id}")
    public ResponseEntity<Justificatif> findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/justificatif/{id}")
    public ResponseEntity<Justificatif> updateJustificatif(@PathVariable("id") long id, @RequestBody Justificatif justificatif) {
        System.out.println("Le justificatif avec l'id $id a été mis à jour...");

        Optional<Justificatif> justificatifData = repository.findById(id);

        if(justificatifData.isPresent()){
            Justificatif _justificatif = justificatifData.get();
            _justificatif.setAdresse(justificatif.getAdresse());
            _justificatif.setAbsence(justificatif.getAbsence());
            return new ResponseEntity<>(repository.save(_justificatif), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
