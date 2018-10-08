package com.krhonos.contract.controller;

import com.krhonos.contract.model.Contrat;
import com.krhonos.contract.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContractController {

  @Autowired ContractRepository repository;

  @GetMapping("/contrats")
  public List<Contrat> getAllContrat() {
    System.out.println("Récuperer tout les contrats");

    List<Contrat> contrats = new ArrayList<>();
    repository.findAll().forEach(contrats::add);

    return contrats;
  }

  @PostMapping(value = "/Contrat/create")
  public Contrat postContrat(@RequestBody Contrat contrat) {
    return repository.save(
        new Contrat(
            contrat.getNomPoste(),
            contrat.getNatureContrat(),
            contrat.getLieuTravail(),
            contrat.getNomEmployeur(),
            contrat.getDateEmbauche(),
            contrat.getDebutEmbauche(),
            contrat.getDureeTravail(),
            contrat.getFinContrat()
        )
    );
  }
}
