package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.dao.EtablissementDao;
import com.krhonos.etablissement.model.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EtablissementController {

  @Autowired
  EtablissementDao repository;

  @GetMapping("/etab")
  public List<Etablissement> getAllEtablissements() {
    System.out.println("Récuperer tout les établissements");
    List<Etablissement> etablissements = new ArrayList<>();
    repository.findAll().forEach(etablissements::add);
    return etablissements;
  }

  @PostMapping(value = "/etab/create")
  private Etablissement postEtablissement(@RequestBody Etablissement etablissement) {
    return repository.save(
            new Etablissement(
                    etablissement.getId(),
                    etablissement.getNom(),
                    etablissement.getSiret(),
                    etablissement.getAdresse(),
                    etablissement.getCodePostal(),
                    etablissement.getVille(),
                    etablissement.getNumero()));
  }

  @DeleteMapping("/etab/{id}")
  public ResponseEntity<String> deleteEtablissement(@PathVariable("id") long id) {
    System.out.println("Suppression de l'établissement avec l'id= $id...");
    repository.deleteById(id);
    return new ResponseEntity<>("Le établissement a été supprimé", HttpStatus.OK);
  }

  @PutMapping("/etab/{id}")
  public ResponseEntity<Etablissement> updateEtablissement(
          @PathVariable("id") long id, @RequestBody Etablissement etablissement) {
    System.out.println("Etablissement avec l'id: $id mise à jour...");
    return null;
  }

  @GetMapping("/etab/id/{id}")
  public Etablissement findById(@PathVariable long id) {
    if (repository.findById(id).isPresent()) {
      return repository.findById(id).get();
    }
    return null;
  }
}
