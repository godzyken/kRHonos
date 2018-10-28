package com.krhonos.calendrier.controller;

import com.krhonos.calendrier.model.TypeAbsence;
import com.krhonos.calendrier.dao.TypeAbsenceDao;
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
    public TypeAbsenceDao typeAbsenceDao;

    @GetMapping("/type_absence")
    public List<TypeAbsence> getAllTypeAbsences() {
        System.out.println("Tous les contrats_planning...");

        List<TypeAbsence> typeAbsences = new ArrayList<>();
        typeAbsenceDao.findAll().forEach(typeAbsences::add);

        return typeAbsences;
    }

    @PostMapping(value = "/type_absence/create")
    public TypeAbsence postTypeAbsence(@RequestBody TypeAbsence typeAbsence) {
        TypeAbsence _typeAbsence = typeAbsenceDao.save(new TypeAbsence(typeAbsence.getLibelleCourt(), typeAbsence.getLibelleLong(), typeAbsence.getFormat()));
        return _typeAbsence;
    }

    @DeleteMapping("/type_absence/{id}")
    public ResponseEntity<String> deleteTypeAbsence(@PathVariable("id") long id) {
        System.out.println("Suppression du type_absence avec l'id : $id...");

        typeAbsenceDao.deleteById(id);

        return new ResponseEntity<>("Le type_absence a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "type_absence/{id}")
    public ResponseEntity<TypeAbsence> findById(@PathVariable long id) {
        if(typeAbsenceDao.findById(id).isPresent()){
            return new ResponseEntity<>(typeAbsenceDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/type_absence/{id}")
    public ResponseEntity<TypeAbsence> updateTypeAbsence(@PathVariable("id") long id, @RequestBody TypeAbsence typeAbsence) {
        System.out.println("Le type_absence avec l'id $id a été mis à jour...");

        Optional<TypeAbsence> typeAbsenceData = typeAbsenceDao.findById(id);

        if(typeAbsenceData.isPresent()){
            TypeAbsence _typeAbsence = typeAbsenceData.get();
            _typeAbsence.setLibelleCourt(typeAbsence.getLibelleCourt());
            _typeAbsence.setLibelleLong(typeAbsence.getLibelleLong());
            _typeAbsence.setFormat(typeAbsence.getFormat());
            return new ResponseEntity<>(typeAbsenceDao.save(_typeAbsence), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
