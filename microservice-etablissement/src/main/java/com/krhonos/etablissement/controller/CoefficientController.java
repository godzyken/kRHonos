package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.dao.CoefficientDao;
import com.krhonos.etablissement.model.Coefficient;
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
public class CoefficientController {

    @Autowired
    CoefficientDao coefficientDao;

    @GetMapping("/coefficient")
    public List<Coefficient> getAllCoefficients() {
        List<Coefficient> coefficients = new ArrayList<>();
        coefficientDao.findAll().forEach(coefficients::add);

        return coefficients;
    }

    @PostMapping(value = "/coefficient/create")
    public Coefficient postCoefficient(@RequestBody Coefficient coefficient) {
        return coefficientDao.save(
                new Coefficient(
                        coefficient.getValeur(),
                        coefficient.getAnciennete()
                )
        );
    }

    @DeleteMapping("/coefficient/{id}")
    public ResponseEntity<String> deleteCoefficient(@PathVariable("id") long id) {
        coefficientDao.deleteById(id);

        return new ResponseEntity<>("Le coefficient a été supprimé", HttpStatus.OK);
    }

    @PutMapping("/coefficient/{id}")
        public ResponseEntity<Coefficient> updateCoefficient(@PathVariable("id") long id, @RequestBody Coefficient coefficient) {

        Optional<Coefficient> coefficientData = coefficientDao.findById(id);

            if(coefficientData.isPresent()){
                Coefficient _coefficient = coefficientData.get();
                _coefficient.setValeur(coefficient.getValeur());
                _coefficient.setAnciennete(coefficient.getAnciennete());
                return new ResponseEntity<>(coefficientDao.save(_coefficient), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
