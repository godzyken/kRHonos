package com.krhonos.salaried.controller;

import com.krhonos.salaried.model.Salarie;
import com.krhonos.salaried.repository.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class salarieController {

  @Autowired SalarieRepository repository;

  @GetMapping("/salaried")
  public List<Salarie> getAllSalaried() {
    System.out.println("Get all salaried...");

    List<Salarie> salaries = new ArrayList<>();
    repository.findAll().forEach(salaries::add);

    return salaries;
  }

  @PostMapping(value = "/salaried/create")
  public Salarie postSalaried(@RequestBody Salarie salarie) {
    Salarie _salarie =
        repository.save(
            new Salarie(
                salarie.getNom(),
                salarie.getNomNaissance(),
                salarie.getPrenom(),
                salarie.getNumSecu(),
                salarie.getCleSecu(),
                salarie.getAdresse(),
                salarie.getCodePostal(),
                salarie.getVille(),
                salarie.getTelephone(),
                salarie.getMail(),
                salarie.getDateNaissance(),
                salarie.getCpNaissance(),
                salarie.getVilleNaissance(),
                salarie.getDateEntree(),
                salarie.getCivilite(),
                salarie.getSituationFam()));

    return _salarie;
  }

  // test
  @GetMapping(value = "salaried/{id}")
  public Salarie findById(@PathVariable long id) {

    if (repository.findById(id).isPresent()) {
      return repository.findById(id).get();
    }
    return null;
  }
}
