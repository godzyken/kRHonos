package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.dao.CoefficientDao;
import com.krhonos.etablissement.dao.ConventionDao;
import com.krhonos.etablissement.model.Coefficient;
import com.krhonos.etablissement.model.Convention;
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
public class ConventionController {

    @Autowired
    ConventionDao conventionDao;

    @GetMapping("/conventions")
    public List<Convention> getAllConvention() {
        List<Convention> conventions = new ArrayList<>();
        conventionDao.findAll().forEach(conventions::add);

        return conventions;
    }

    @PostMapping(value = "/conventions/create")
    public Convention postConvention(@RequestBody Convention convention) {
        return conventionDao.save(
                new Convention(
                        convention.getLibelle(),
                        convention.getValeurPoint()
                )
        );
    }

    @DeleteMapping("/conventions/{id}")
    public ResponseEntity<String> deleteConvention(@PathVariable("id") long id) {
        conventionDao.deleteById(id);

        return new ResponseEntity<>("La convention a été supprimée", HttpStatus.OK);
    }

    @PutMapping("/conventions/{id}")
    public ResponseEntity<Convention> updateConvention(@PathVariable("id") long id, @RequestBody Convention convention) {
        Optional<Convention> conventionData = conventionDao.findById(id);

        if(conventionData.isPresent()){
            Convention _convention = conventionData.get();
            _convention.setLibelle(convention.getLibelle());
            _convention.setValeurPoint(convention.getValeurPoint());
            return new ResponseEntity<>(conventionDao.save(_convention), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
