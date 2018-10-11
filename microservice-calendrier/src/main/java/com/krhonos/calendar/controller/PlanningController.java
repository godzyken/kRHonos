package com.krhonos.calendar.controller;

import com.krhonos.calendar.model.Planning;
import com.krhonos.calendar.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        Planning _planning = repository.save(new Planning(planning.getTitle(), planning.getStart(), planning.getEnd()));
        return _planning;
    }
}
