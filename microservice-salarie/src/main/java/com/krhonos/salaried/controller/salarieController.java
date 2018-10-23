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

    @Autowired
    SalarieRepository repository;

    @GetMapping("/salaried")
    public List<Salarie> getAllSalaried() {
        List<Salarie> salaries = new ArrayList<>();
        repository.findAll().forEach(salaries::add);

        return salaries;
    }

    @PostMapping(value = "/salaried/create")
    public Salarie postSalaried(@RequestBody Salarie salarie) {
        Salarie _salarie = repository.save(new Salarie(
                salarie.getNumSecu(),
                salarie.getCleSecu(),
                salarie.getDateNaissance(),
                salarie.getCivilite(),
                salarie.getSituationFam()
        ));

        return _salarie;
    }

    @GetMapping(value = "salaried/{id}")
    public Salarie findById(@PathVariable long id) {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        return null;
    }

}
