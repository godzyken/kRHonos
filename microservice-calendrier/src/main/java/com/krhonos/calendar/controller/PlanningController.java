package com.krhonos.calendar.controller;

import com.krhonos.calendar.model.Planning;
import com.krhonos.calendar.repository.PlanningRepository;
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
public class PlanningController {

    @Autowired
    PlanningRepository repository;

    @GetMapping("/planning")
    public List<Planning> getAllPlanning() {
        System.out.println("Get all planning...");

        List<Planning> plannings = new ArrayList<>();
        repository.findAll().forEach(plannings::add);

        return plannings;
    }

    @PostMapping(value = "/planning/create")
    public Planning postPlanning(@RequestBody Planning planning) {
        System.out.println("Le planning a été créé avec succès");
        Planning _planning = repository.save(new Planning(planning.getStart(), planning.getEnd()));
        return _planning;
    }

    @DeleteMapping("/planning/{id}")
    public ResponseEntity<String> deletePlanning(@PathVariable("id") long id){
        System.out.println("Suppression du planning avec l'id = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Le planning a été supprimé", HttpStatus.OK);
    }

    @PutMapping("/planning/{id}")
    public ResponseEntity<Planning> updatePlanning(@PathVariable("id") long id, @RequestBody Planning planning) {
        System.out.println("Planning avec l'id : " + id + " mis à jour...");

        Optional<Planning> planningData = repository.findById(id);

        if(planningData.isPresent()) {
            Planning _planning = planningData.get();
            _planning.setStart(planning.getStart());
            _planning.setEnd(planning.getEnd());
            return new ResponseEntity<>(repository.save(_planning), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
