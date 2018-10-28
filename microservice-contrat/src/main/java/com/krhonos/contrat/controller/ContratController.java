package com.krhonos.contrat.controller;

import com.krhonos.contrat.model.Contrat;
import com.krhonos.contrat.dao.ContratDao;
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
public class ContratController {

    @Autowired
    ContratDao contratDao;

    @GetMapping("/contrats")
    public List<Contrat> getAllContrats() {
        System.out.println("Récuperer tout les contrats");

        List<Contrat> contrats = new ArrayList<>();
        contratDao.findAll().forEach(contrats::add);

        return contrats;
    }

    @PostMapping(value = "/contrats/create")
    public Contrat postContrat(@RequestBody Contrat contrat) {
        return contratDao.save(
                new Contrat(
                        contrat.getDateDebut(),
                        contrat.getDateFin(),
                        contrat.getTempsTravail(),
                        contrat.getSalarieId(),
                        contrat.getNatureContrat(),
                        contrat.getEmploiId(),
                        contrat.getContratService()));
    }

    @DeleteMapping("/contrats/{id}")
    public ResponseEntity<String> deleteContrat(@PathVariable("id") long id) {
        System.out.println("Suppression du contrat $id.");

        contratDao.deleteById(id);

        return new ResponseEntity<>("Le contrat a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "contrats/{id}")
    public ResponseEntity<Contrat> findById(@PathVariable long id) {
        if(contratDao.findById(id).isPresent()){
            return new ResponseEntity<>(contratDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/contrats/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable("id") long id, @RequestBody Contrat contrat) {
        System.out.println("Contrat avec l'id: $id mis à jour.");

        Optional<Contrat> contratData = contratDao.findById(id);

        if(contratData.isPresent()){
            Contrat _contrat = contratData.get();
            _contrat.setDateDebut(contrat.getDateDebut());
            _contrat.setDateFin(contrat.getDateFin());
            _contrat.setTempsTravail(contrat.getTempsTravail());
            _contrat.setSalarieId(contrat.getSalarieId());
            _contrat.setNatureContrat(contrat.getNatureContrat());
            _contrat.setEmploiId(contrat.getEmploiId());
            _contrat.setContratService(contrat.getContratService());
            return new ResponseEntity<>(contratDao.save(_contrat), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}