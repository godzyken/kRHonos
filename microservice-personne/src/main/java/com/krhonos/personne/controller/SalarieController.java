package com.krhonos.personne.controller;

import com.krhonos.personne.model.Salarie;
import com.krhonos.personne.dao.SalarieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalarieController {


  @Autowired
  SalarieDao salarieDao;

  @GetMapping("/salaried")
  public List<Salarie> getAllSalaried() {
    List<Salarie> salaries = new ArrayList<>();
    salarieDao.findAll().forEach(salaries::add);

    return salaries;
  }

  @PostMapping(value = "/salaried/create")
  public Salarie postSalaried(@RequestBody Salarie salarie) {
    Salarie _salarie =
        salarieDao.save(
            new Salarie(
                salarie.getNom(),
                salarie.getNomNaissance(),
                salarie.getPrenom(),
                salarie.getNumSecu(),
                salarie.getCleSecu(),
                salarie.getDateNaissance(),
                salarie.getSituationFam()));

    return _salarie;
  }

  @GetMapping(value = "/salaried/{id}")
  public Salarie findById(@PathVariable long id) {

    if (salarieDao.findById(id).isPresent()) {
      return salarieDao.findById(id).get();
    }
    return null;
  }

}
