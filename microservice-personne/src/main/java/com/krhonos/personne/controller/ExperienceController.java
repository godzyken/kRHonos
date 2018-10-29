package com.krhonos.personne.controller;

import com.krhonos.personne.dao.ExperienceDao;
import com.krhonos.personne.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ExperienceController {

    @Autowired
    ExperienceDao experienceDao;

    @GetMapping("/experience")
    public List<Experience> getAllSalaried() {
        List<Experience> experiences = new ArrayList<>();
        experienceDao.findAll().forEach(experiences::add);

        return experiences;
    }

    @GetMapping(value = "/experience/{id}")
    public Experience findById(@PathVariable long id) {

        if (experienceDao.findById(id).isPresent()) {
            return experienceDao.findById(id).get();
        }
        return null;
    }

    @PostMapping(value = "/experience/create")
    public Experience postExperience(@RequestBody Experience experience) {
        Experience _experience =
                experienceDao.save(
                        new Experience(
                                experience.getNomEntreprise(),
                                experience.getDateDebut(),
                                experience.getDateFin(),
                                experience.getDescriptif(),
                                experience.getPersonne()

                        )
                );

        return _experience;
    }
}
