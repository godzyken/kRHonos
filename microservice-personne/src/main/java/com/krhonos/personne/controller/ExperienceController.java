package com.krhonos.personne.controller;

import com.krhonos.personne.dao.ExperienceDao;
import com.krhonos.personne.model.Document;
import com.krhonos.personne.model.Experience;
import com.krhonos.personne.service.ModelMapperService;
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
    @Autowired
    ModelMapperService modelMapperService;

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


    @PutMapping(value = "/experience/update/{id}")
    public Experience updateExperience(@PathVariable long id, @RequestBody Experience experience) {
        Experience _experience = experienceDao.findById(id).get();
        if (_experience != null) {
            modelMapperService.map(experience, _experience);
            experienceDao.save(_experience);
        }
        return _experience;
    }

    @DeleteMapping(value = "/experience/delete/{id}")
    public void deleteExperience(@PathVariable long id) {
        experienceDao.deleteById(id);
    }
}
