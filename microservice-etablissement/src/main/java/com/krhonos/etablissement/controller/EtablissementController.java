package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.dao.EtablissementDao;
import com.krhonos.etablissement.model.Etablissement;
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
public class EtablissementController {

    @Autowired
    EtablissementDao etablissementDao;

    @GetMapping("/etablissements")
    public List<Etablissement> getAllEtablissements() {
        System.out.println("Récuperer tout les établissements");

        List<Etablissement> etablissements = new ArrayList<>();
        etablissementDao.findAll().forEach(etablissements::add);

        return etablissements;
    }

    @PostMapping(value = "/etablissements/create")
    public Etablissement postEtablissement(@RequestBody Etablissement etablissement) {
        return etablissementDao.save(
                new Etablissement(
                        etablissement.getNom(),
                        etablissement.getSiret(),
                        etablissement.getConvention(),
                        etablissement.getContactId()
                )
        );
    }

    @DeleteMapping("/etablissements/{id}")
    public ResponseEntity<String> deleteEtablissement(@PathVariable("id") long id) {
        System.out.println("Suppression de l'établissement avec l'id= $id...");

        etablissementDao.deleteById(id);

        return new ResponseEntity<>("L'établissement a été supprimé", HttpStatus.OK);
    }

    @PutMapping("/etablissements/{id}")
    public ResponseEntity<Etablissement> updateEtablissement(@PathVariable("id") long id, @RequestBody Etablissement etablissement) {
        System.out.println("Etablissement avec l'id: $id mise à jour...");

        Optional<Etablissement> etablissementData = etablissementDao.findById(id);

        if(etablissementData.isPresent()){
            Etablissement _etablissement = etablissementData.get();
            _etablissement.setNom(etablissement.getNom());
            _etablissement.setSiret(etablissement.getSiret());
            _etablissement.setConvention(etablissement.getConvention());
            _etablissement.setContactId(etablissement.getContactId());
            return new ResponseEntity<>(etablissementDao.save(_etablissement), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/etablissements/id/{id}")
    public ResponseEntity<Etablissement> findById(@PathVariable long id) {
        if (etablissementDao.findById(id).isPresent()) {
            return new ResponseEntity<>(etablissementDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
