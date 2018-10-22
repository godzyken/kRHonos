package com.krhonos.calendar.controller;

import com.krhonos.calendar.model.ContratPlanning;
import com.krhonos.calendar.repository.ContratPlanningRepository;
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
public class ContratPlanningController {
    @Autowired
    public ContratPlanningRepository repository;

    @GetMapping("/contrat_planning")
    public List<ContratPlanning> getAllContratPlannings() {
        System.out.println("Tous les contrats_planning...");

        List<ContratPlanning> contratPlannings = new ArrayList<>();
        repository.findAll().forEach(contratPlannings::add);

        return contratPlannings;
    }

    @PostMapping(value = "/contrat_planning/create")
    public ContratPlanning postContratPlanning(@RequestBody ContratPlanning contratPlanning) {
        ContratPlanning _contratPlanning = repository.save(new ContratPlanning(contratPlanning.getPlanning(), contratPlanning.getContratId()));
        return _contratPlanning;
    }

    @DeleteMapping("/contrat_planning/{id}")
    public ResponseEntity<String> deleteContratPlanning(@PathVariable("id") long id) {
        System.out.println("Suppression du contrat_planning avec l'id : $id...");

        repository.deleteById(id);

        return new ResponseEntity<>("Le contrat_planning a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "contrat_planning/{id}")
    public ResponseEntity<ContratPlanning> findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/contrat_planning/{id}")
    public ResponseEntity<ContratPlanning> updateContratPlanning(@PathVariable("id") long id, @RequestBody ContratPlanning contratPlanning) {
        System.out.println("Le contrat_planning avec l'id $id a été mis à jour...");

        Optional<ContratPlanning> contratPlanningData = repository.findById(id);

        if(contratPlanningData.isPresent()){
            ContratPlanning _contratPlanning = contratPlanningData.get();
            _contratPlanning.setPlanning(contratPlanning.getPlanning());
            _contratPlanning.setContratId(contratPlanning.getContratId());
            return new ResponseEntity<>(repository.save(_contratPlanning), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
