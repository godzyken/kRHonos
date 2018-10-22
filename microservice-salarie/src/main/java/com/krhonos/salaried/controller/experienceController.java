package com.krhonos.salaried.controller;


import com.krhonos.salaried.model.Experience;
import com.krhonos.salaried.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class experienceController {

    @Autowired
    ExperienceRepository repository;

    @GetMapping("/experience")
    public List<Experience> getAllExperience() {

        System.out.println("Get All Experience...");

        List<Experience> experiences = new ArrayList<>();
        repository.findAll().forEach(experiences::add);
        return experiences;
    }

    @PostMapping(value = "/experience/create")
    public Experience postExperience(@RequestBody Experience experience) {
        Experience _experience =
                repository.save(
                        new Experience(
                                experience.getNomEntreprise(),
                                experience.getDateDebut(),
                                experience.getDateFin(),
                                experience.getDescriptif()
                        )
                );
        return _experience;
    }

    @GetMapping(value = "/experience/{id}")
    public Experience findById(@PathVariable long id) {
        if (repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }
        return null;
    }
}
