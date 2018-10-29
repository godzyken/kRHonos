package com.krhonos.calendrier.controller;

import com.krhonos.calendrier.dao.CongeValidationDao;
import com.krhonos.calendrier.model.CongeValidation;
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
public class CongeValidationController {

    @Autowired
    CongeValidationDao congeValidationDao;

    @GetMapping("/conge_validations")
    public List<CongeValidation> getAllCongeValidations() {
        System.out.println("Tous les congesValidations...");

        List<CongeValidation> congeValidations = new ArrayList<>();
        congeValidationDao.findAll().forEach(congeValidations::add);

        return congeValidations;
    }

    @PostMapping(value = "/conge_validations/create")
    public CongeValidation postCongeValidation(@RequestBody CongeValidation congeValidation) {
        CongeValidation _congeValidation = congeValidationDao.save(new CongeValidation(
                congeValidation.getStatus()));
        return _congeValidation;
    }

    @DeleteMapping("/conge_validations/{id}")
    public ResponseEntity<String> deleteCongeValidation(@PathVariable("id") long id) {
        System.out.println("Suppression du congé avec l'id : " + id + "...");

        congeValidationDao.deleteById(id);

        return new ResponseEntity<>("Le congé a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "conge_validations/{id}")
    public ResponseEntity<CongeValidation> findById(@PathVariable long id) {
        if(congeValidationDao.findById(id).isPresent()){
            return new ResponseEntity<>(congeValidationDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/conge_validations/{id}")
    public ResponseEntity<CongeValidation> updateCongeValidation(@PathVariable("id") long id, @RequestBody CongeValidation congeValidation) {
        System.out.println("Le congé avec l'id " + id + " a été mis à jour...");

        Optional<CongeValidation> congeValidationData = congeValidationDao.findById(id);

        if(congeValidationData.isPresent()){
            CongeValidation _congeValidation = congeValidationData.get();
            _congeValidation.setStatus(congeValidation.getStatus());
            return new ResponseEntity<>(congeValidationDao.save(_congeValidation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
