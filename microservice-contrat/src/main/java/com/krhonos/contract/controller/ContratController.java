package com.krhonos.contract.controller;

import com.krhonos.contract.model.Contrat;
import com.krhonos.contract.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContratController {

  @Autowired
<<<<<<< HEAD
  ContractRepository repository;
=======
  ContratRepository repository;
>>>>>>> master

  @GetMapping("/contrats")
  public List<Contrat> getAllContrats() {
    System.out.println("Récuperer tout les contrats");

    List<Contrat> contrats = new ArrayList<>();
    repository.findAll().forEach(contrats::add);

    return contrats;
  }

  @PostMapping(value = "/Contrat/create")
  public Contrat postContrat(@RequestBody Contrat contrat) {
    return repository.save(
            new Contrat(
                    contrat.getDateDebut(),
                    contrat.getDateFin(),
                    contrat.getTempsTravail(),
                    contrat.getSalarieId(),
                    contrat.getNatureCtrId(),
                    contrat.getEmploiId()));
  }

  @DeleteMapping("/contrat/{id}")
  public ResponseEntity<String> deleteContrat(@PathVariable("id") long id){
    System.out.println("Suppression du contrat ace l'id= $id...");

    repository.deleteById(id);

    return new ResponseEntity<>("Le contrat a été supprimé", HttpStatus.OK);
  }

  @PutMapping("/contrat/{id}")
  public ResponseEntity<Contrat> updateContrat(@PathVariable("id") long id, @RequestBody Contrat contrat){
    System.out.println("Contrat avec l'id: $id mis à jour...");
    /*
    Optional<Contrat> contratData = repository.findById(id);

    if (contratData.isPresent()){
      Contrat contrat1 = contratData.get();
      contrat1.setDateEmbauche(contrat.getDateEmbauche());
      contrat1.setDebutEmbauche(contrat.getDebutEmbauche());
      contrat1.setDureeTravail(contrat.getDureeTravail());
      contrat1.setDroitCongesPayes(contrat.getDroitCongesPayes());
      contrat1.setFinContrat(contrat.getFinContrat());

      return  new ResponseEntity<>(repository.save(contrat1), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    */
    return null;
  }
}
