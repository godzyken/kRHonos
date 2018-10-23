package com.krhonos.calendar.controller;

import com.krhonos.calendar.model.TypeAbsence;
import com.krhonos.calendar.dao.TypeAbsenceDao;
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
public class TypeAbsenceController {
    @Autowired
    public TypeAbsenceDao repository;

    @GetMapping("/type_absence")
    public List<TypeAbsence> getAllTypeAbsences() {
        System.out.println("Tous les contrats_planning...");

        List<TypeAbsence> typeAbsences = new ArrayList<>();
        repository.findAll().forEach(typeAbsences::add);

        return typeAbsences;
    }

    @PostMapping(value = "/type_absence/create")
    public TypeAbsence postTypeAbsence(@RequestBody TypeAbsence typeAbsence) {
        TypeAbsence _typeAbsence = repository.save(new TypeAbsence(typeAbsence.getLibelleCourt(), typeAbsence.getLibelleLong(), typeAbsence.getFormat()));
        return _typeAbsence;
    }

    @DeleteMapping("/type_absence/{id}")
    public ResponseEntity<String> deleteTypeAbsence(@PathVariable("id") long id) {
        System.out.println("Suppression du type_absence avec l'id : $id...");

        repository.deleteById(id);

        return new ResponseEntity<>("Le type_absence a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "type_absence/{id}")
    public ResponseEntity<TypeAbsence> findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/type_absence/{id}")
    public ResponseEntity<TypeAbsence> updateTypeAbsence(@PathVariable("id") long id, @RequestBody TypeAbsence typeAbsence) {
        System.out.println("Le type_absence avec l'id $id a été mis à jour...");

        Optional<TypeAbsence> typeAbsenceData = repository.findById(id);

        if(typeAbsenceData.isPresent()){
            TypeAbsence _typeAbsence = typeAbsenceData.get();
            _typeAbsence.setLibelleCourt(typeAbsence.getLibelleCourt());
            _typeAbsence.setLibelleLong(typeAbsence.getLibelleLong());
            _typeAbsence.setFormat(typeAbsence.getFormat());
            return new ResponseEntity<>(repository.save(_typeAbsence), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
