package com.krhonos.contrat.controller;

import com.krhonos.contrat.dao.NatureContratDao;
import com.krhonos.contrat.model.NatureContrat;
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
    public class NatureContratController {

        @Autowired
        NatureContratDao natureContratDao;

        @GetMapping("/nature_contrat")
        public List<NatureContrat> getAllNatureContrats() {
            System.out.println("Toutes les natures des contrats...");

            List<NatureContrat> natureContrat = new ArrayList<>();
            natureContratDao.findAll().forEach(natureContrat::add);

            return natureContrat;
        }

        @PostMapping(value = "/nature_contrat/create")
        public NatureContrat postNatureContrat(@RequestBody NatureContrat natureContrat) {
            NatureContrat _natureContrat = natureContratDao.save(new NatureContrat(
                    natureContrat.getNatureCtrLibelle(),
                    natureContrat.isNatureCtrActif()));
            return _natureContrat;
        }

        @DeleteMapping("/nature_contrat/{id}")
        public ResponseEntity<String> deleteNatureContrat(@PathVariable("id") long id) {
            System.out.println("Suppression de la nature du contrat");

            natureContratDao.deleteById(id);

            return new ResponseEntity<>("La nature du contrat a été supprimée", HttpStatus.OK);
        }

        @GetMapping(value = "nature_contrat/{id}")
        public ResponseEntity<NatureContrat> findById(@PathVariable long id) {
            if (natureContratDao.findById(id).isPresent()) {
                return new ResponseEntity<>(natureContratDao.findById(id).get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping("/nature_contrat/{id}")
        public ResponseEntity<NatureContrat> updateContrat(@PathVariable("id") long id, @RequestBody NatureContrat natureContrat) {
            System.out.println("La nature de contrat avec l'id " +id+ " a été mis à jour...");

            Optional<NatureContrat> natureContratData = natureContratDao.findById(id);

            if(natureContratData.isPresent()){
                NatureContrat _natureContrat = natureContratData.get();
                _natureContrat.setNatureCtrLibelle(natureContrat.getNatureCtrLibelle());
                _natureContrat.setNatureCtrActif(natureContrat.isNatureCtrActif());
                return new ResponseEntity<>(natureContratDao.save(_natureContrat), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    }

